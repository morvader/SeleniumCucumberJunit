package openCartTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.openCart.MainPage;
import pages.openCart.ResultsPage;

import java.io.IOException;

import static Base.ScreenshotWatcher.captureScreenshot;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStepdefs {

    private WebDriver driver;

    private World world;

    MainPage mainPage;
    ResultsPage resultsPage;

    public MyStepdefs(World world) {
        this.world = world;
    }

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        world.driver = driver;

        mainPage = new MainPage(driver);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed())
            captureScreenshot(driver, "./screenshot", scenario.getName());
        driver.quit();
    }

    @Given("^Estoy en la pagina principal$")
    public void estoyEnLaPaginaPrincipal() {
        mainPage.navigateTo();
    }

    @When("^busco el elemento \"([^\"]*)\"$")
    public void buscoElElemento(String item) throws Throwable {
        resultsPage = mainPage.searchItem(item);
        world.selectedItemName = item;
    }

    @Then("^el elemento \"([^\"]*)\" aparece en los resultados con el precio \"([^\"]*)\"$")
    public void elElementoApareceEnLosResultadosConElPrecio(String nombreEsperado, String precioEsperado) throws Throwable {
        final String elementName = resultsPage.getElementName(0);
        final String elementPrice = resultsPage.getElementPrice(0);

        assertEquals(elementName, nombreEsperado, "El nombre del elemento no coincide");
        assertTrue(elementPrice.startsWith(precioEsperado), "El precio del elemeno no coincide");
    }


}
