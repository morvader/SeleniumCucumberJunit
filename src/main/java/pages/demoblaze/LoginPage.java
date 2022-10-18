package pages.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By inputUserName = By.id("loginusername");
    By inputPassword = By.id("loginpassword");

    By btnLogin = By.xpath("//*[@id=\"logInModal\"]//button[2]");

    public LoginPage loginAs(String user, String pass){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUserName));

        driver.findElement(inputUserName).sendKeys(user);
        driver.findElement(inputPassword).sendKeys(pass);

        driver.findElement(btnLogin).click();

        return this;

    }

    public String getTextAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        return driver.switchTo().alert().getText();

    }
}
