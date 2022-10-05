package Base;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ScreenshotWatcher implements AfterTestExecutionCallback, TestWatcher {

    static WebDriver driver;
    String path="./screenshot";


    public static void setDriver(WebDriver driver) {
        ScreenshotWatcher.driver = driver;
    }


    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        Boolean testFailed =  extensionContext.getExecutionException().isPresent();

        if(testFailed) {
            String baseFileName = extensionContext.getRequiredTestClass().getSimpleName() + "-"
                    + extensionContext.getRequiredTestMethod().getName()
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("-yyMMdd-HHmmss"));

            captureScreenshot(driver, path, baseFileName);
        }
    }

    public static void captureScreenshot(WebDriver driver, String path, String fileName) {
        try {
            new File(path).mkdirs();
            try ( FileOutputStream out = new FileOutputStream(path + File.separator + "screenshot-" + fileName + ".png")) {
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException e) {
            System.out.println("screenshot failed:" + e.getMessage());
        }
    }
}
