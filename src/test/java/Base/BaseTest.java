package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ReadConfig;

import java.net.MalformedURLException;
import java.net.URL;

@ExtendWith(ScreenshotWatcher.class)
public class BaseTest {

    public WebDriver driver;

    public void setup() {
        try {
            this.setupWebDriverManager();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    public void setupWebDriverManager() throws MalformedURLException {

        String configFileName = System.getProperty("configFile")!=null?System.getProperty("configFile"):"./config/localconfig.properties";

        String navegador = ReadConfig.getProperty(configFileName, "browser");
        String tipoEjecucion = ReadConfig.getProperty(configFileName, "tipoEjecucion");
        if (tipoEjecucion.equals("local")) {

            switch (navegador) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

        } else {
            String URL = ReadConfig.getProperty(configFileName, "remoteUrl");
            String os = ReadConfig.getProperty(configFileName, "OS");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", os);
            caps.setCapability("browserName", navegador);
            caps.setCapability("version", "latest");
            driver = new RemoteWebDriver(new URL(URL), caps);
        }

        ScreenshotWatcher.setDriver(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
