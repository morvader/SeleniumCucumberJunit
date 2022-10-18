package pages.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By btnAddToCart = By.cssSelector("a.btn");

    public ProductPage addToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnAddToCart));

        driver.findElement(btnAddToCart).click();

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        return this;
    }
}
