package pages.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    By linkCarrito = By.cssSelector("#cartur");

    public BlazeCartPage gotoCart(){

        driver.findElement(linkCarrito).click();

        return new BlazeCartPage(driver);

    }
}
