package todoMVCTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.todoMVC.MainReactPage;

import java.io.IOException;
import java.util.ArrayList;

import static Base.ScreenshotWatcher.captureScreenshot;
import static org.junit.jupiter.api.Assertions.*;


public class SearchSteptsTest {
    WebDriver driver;
    MainReactPage mainPage;

    ArrayList<String> elementosCompletados;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
        driver = new ChromeDriver();

        elementosCompletados = new ArrayList<>();

        mainPage = new MainReactPage(driver);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed())
            captureScreenshot(driver, "./screenshot∫", scenario.getName());
        driver.quit();
    }

    @Given("^entro en el sistema$")
    public void entroEnElSistema() {
        mainPage.navigateTo();
    }

    @Then("^la lista de elementos está vacía$")
    public void la_lista_de_elementos_está_vacía() throws Throwable {
        int elementos = mainPage.getNumberOfElements();
        assertEquals(elementos, 0, "La lista de elementos no está vacía");
    }

    @Then("^la lista tiene (\\d+) elemento$")
    public void laListaTieneElemento(int nElementos) {
        int elementos = mainPage.getNumberOfElements();
        assertEquals(elementos, nElementos, "La lista de elementos no está vacía");
    }

    @And("^marco el elemento (\\d+) como completado$")
    public void marcoElElementoComoCompletado(int nElemento) {
        String nombreElemento = mainPage.getListElementName(nElemento);
        elementosCompletados.add(nombreElemento);

        mainPage.completeElement(nElemento);
    }

    @Then("^aparece en la lista de completados$")
    public void apareceEnLaListaDeCompletados() {
        mainPage.clickCompletedBtn();

        int nElementosCompletados = mainPage.getCompletedlistSize();

        assertEquals(nElementosCompletados, elementosCompletados.size(), "El numero de elementos completados no es correcto");
    }

    @Then("^el elemento (\\d+) queda marcado como completado$")
    public void elElementoQuedaMarcadoComoCompletado(int nElemento) {
        assertTrue(mainPage.isElementCompleted(nElemento), "El elemento no se ha marcado como completado");
    }

    @When("^añado el elemento \"([^\"]*)\" a lista$")
    public void añadoElElementoALista(String newElement) throws Throwable {
        mainPage.addNewTodo(newElement);
    }

    @And("^la lista contiene el elemento \"([^\"]*)\"$")
    public void laListaContieneElElemento(String nombreElemento) throws Throwable {
        final ArrayList<String> nombreElementos = mainPage.getElementNames();
        assertTrue(nombreElementos.contains(nombreElemento), "La lista no contiene el elmento buscado");
    }

    @When("^elimino el elemento (\\d+)")
    public void eliminoElElemento(int nElemento) throws Throwable {
        mainPage.deleteElement(nElemento);
    }

    @Then("^el elemento \"([^\"]*)\" deja de aparecer en las listas$")
    public void elElementoDejaDeAparecerEnLasListas(String nombreElemento) throws Throwable {
        final ArrayList<String> nombreElementos = mainPage.getElementNames();
        assertFalse(nombreElementos.contains(nombreElemento), "La lista no contiene el elmento buscado");
    }
}
