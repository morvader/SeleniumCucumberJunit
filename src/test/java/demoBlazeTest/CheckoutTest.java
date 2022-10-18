package demoBlazeTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoblaze.BlazeCartPage;
import pages.demoblaze.HomePage;
import pages.demoblaze.ProductPage;
import pages.todo.TodoMainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTest {

    private WebDriver driver;

    HomePage demoBlazeHomePage;

    @BeforeEach
    public void prepararEntorno() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

        driver = new ChromeDriver();

        demoBlazeHomePage = new HomePage(driver);

        driver.get("https://www.demoblaze.com/");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void comprarPrimerItem() {

        String elementoAComprarEsperado = "Samsung galaxy s6";
        int precioEsperado = 360;

        BlazeCartPage blazeCartPage = demoBlazeHomePage
                .seleccionaProducto(0)
                .addToCart()
                .gotoCart();

        String nombreElementoFinal = blazeCartPage.getNombreElementoPosicion(0);
        int precioTotalFinal = blazeCartPage.getPrecioTotal();

        assertEquals(elementoAComprarEsperado,nombreElementoFinal);
        assertEquals(precioEsperado,precioTotalFinal);

    }
}
