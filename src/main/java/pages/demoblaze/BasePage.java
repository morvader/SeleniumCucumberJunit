package pages.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    By linkCarrito = By.cssSelector("#cartur");
    By linkLogin = By.id("login2");

    By userName = By.id("nameofuser");

    public BlazeCartPage gotoCart(){

        driver.findElement(linkCarrito).click();

        return new BlazeCartPage(driver);

    }

    public LoginPage gotoLogin(){
        driver.findElement(linkLogin).click();

        return new LoginPage(driver);
    }

    public String getUserName(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
       return driver.findElement(userName).getText();
    }
}
