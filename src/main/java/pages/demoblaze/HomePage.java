package pages.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private String URL = "https://www.demoblaze.com/";
    By listaTarjetasProducto = By.cssSelector("#tbodyid .card");
    By enlaceDelNombreProducto = By.cssSelector("#tbodyid .card .card-title a");

    public HomePage visit(){
        driver.get(this.URL);
        return this;
    }
    public int getNumeroTotalProductos(){
        return driver.findElements(listaTarjetasProducto).size();

    }


    public ProductPage seleccionaProducto(int posicion){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.
                numberOfElementsToBeMoreThan(enlaceDelNombreProducto,0));

        driver
                .findElements(enlaceDelNombreProducto) //lista de productos
                .get(posicion) //Elemento en la posicion X
                .click();

        return new ProductPage(driver);
    }
}
