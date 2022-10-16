package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(ScreenshotWatcher.class)
public class BaseTest {

    public WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 6/7/8");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = WebDriverManager.chromedriver().capabilities(options).create();

        ScreenshotWatcher.setDriver(driver);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
