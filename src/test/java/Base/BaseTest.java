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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@ExtendWith(ScreenshotWatcher.class)
public class BaseTest {

    public WebDriver driver;

    @BeforeAll
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
    }
    public void setup()  {

        this.setupWebDriverManager();

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setBrowserName("chrome");
//        try {
//            driver = new RemoteWebDriver(new URL("http://192.168.0.11:4444"), caps);
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//
//        ScreenshotWatcher.setDriver(driver);

    }

    public void setupWebDriverManager(){
        ChromeOptions options = new ChromeOptions();

        WebDriverManager wdm = WebDriverManager.chromedriver().capabilities(options);
        wdm.setup();
        driver = wdm.remoteAddress("http://192.168.0.11:4444/wd/hub").create();
        ScreenshotWatcher.setDriver(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
