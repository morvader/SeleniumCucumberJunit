package pages.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlazeCartPage extends BasePage{
    public BlazeCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By listaNombres = By.xpath("//*[@id=\"tbodyid\"]//td[2]");
    By listaPrecios = By.xpath("//*[@id=\"tbodyid\"]//td[3]");

    By totalPrice = By.id("totalp");

    public String getNombreElementoPosicion(int posicion){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(listaNombres));

         return driver.findElements(listaNombres).get(posicion).getText();

    }

    public float getPrecioElementoPosicion(int posicion){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(listaPrecios));

        return Float.parseFloat(driver.findElements(listaPrecios).get(posicion).getText());

    }

    public int getPrecioTotal(){
        return Integer.parseInt(driver.findElement(totalPrice).getText());
    }



}
