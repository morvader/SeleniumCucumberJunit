package demoBlazeTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoblaze.HomePage;
import pages.demoblaze.ProductPage;
import pages.todo.TodoMainPage;

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
        demoBlazeHomePage
                .seleccionaProducto(0)
                .addToCart();

    }
}
