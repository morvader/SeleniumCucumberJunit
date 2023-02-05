package demoBlazeTest;

import Base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoblaze.BlazeCartPage;
import pages.demoblaze.HomePage;
import pages.demoblaze.ProductPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTest extends BaseTest {

    HomePage demoBlazeHomePage;

    @BeforeEach
    public void prepararEntorno() {
        super.setup();
        demoBlazeHomePage = new HomePage(driver);
        demoBlazeHomePage.visit();

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
