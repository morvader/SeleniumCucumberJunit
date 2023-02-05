package games;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Play1to50 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        driver.get("http://zzzscore.com/1to50/");

        String numberSelector = "//*[@id=\"grid\"]//div[text()=\"%s\"]";
        By resultsSelector = By.cssSelector(".resultContent > .level");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (int i = 1; i <= 50; i++) {
            String xpathSelector = String.format(numberSelector, i);
            driver.findElement(By.xpath(xpathSelector)).click();
        }

        Thread.sleep(2000);

        driver.switchTo().frame("aswift_3");
        try {
            driver.switchTo().frame("ad_iframe");
            driver.findElement(By.id("dismiss-button")).click();
        } catch (NoSuchElementException e){
            driver.switchTo().defaultContent();
            driver.switchTo().frame("aswift_3");
            driver.findElement(By.id("dismiss-button")).click();
        }

        System.out.println("resultado: " + driver.findElement(resultsSelector).getText());

        driver.quit();
    }
}
