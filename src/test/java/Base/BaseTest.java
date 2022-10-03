package Base;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;

@ExtendWith(ScreenshotWatcher.class)
public class BaseTest {

    public WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");

        driver = new ChromeDriver();
        ScreenshotWatcher.setDriver(driver);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
