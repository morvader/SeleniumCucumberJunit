package openCartTests;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.openCart.BasePage;
import pages.openCart.CartPage;
import pages.openCart.ResultsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CartStepdefs {
    WebDriver driver;

    World world;

    ResultsPage resultsPage;

    public CartStepdefs(World world) {
        this.world = world;
        this.driver = world.driver;
        resultsPage = new ResultsPage(driver);
    }

    @And("^añado el elemento \"([^\"]*)\" al carrito$")
    public void añadoElElementoAlCarrito(String item) throws Throwable {
        resultsPage.addElementToCart(item);
    }

    @Then("^el elemento \"([^\"]*)\" se visualiza en la página resumen de carrito$")
    public void elElementoSeVisualizaEnLaPáginaResumenDeCarrito(String item) throws Throwable {
        BasePage base = new BasePage(driver);
        final CartPage cartPage = base.goToCart();

        assertEquals(cartPage.getNItems(), 1, "El número de elementos no coincide");
        assertTrue(cartPage.getItemNames().contains(item), "El elemento no está en el carrito");
    }
}
