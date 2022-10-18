package pages.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    By linkCarrito = By.cssSelector("#cartur");
    By linkLogin = By.id("login2");

    public BlazeCartPage gotoCart(){

        driver.findElement(linkCarrito).click();

        return new BlazeCartPage(driver);

    }

    public LoginPage gotoLogin(){
        driver.findElement(linkLogin).click();

        return new LoginPage(driver);
    }
}
