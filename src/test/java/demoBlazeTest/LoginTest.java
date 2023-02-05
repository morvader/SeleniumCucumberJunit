package demoBlazeTest;

import Base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoblaze.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
    HomePage demoBlazeHomePage;

    @BeforeEach
    public void prepararEntorno() {
        super.setup();

        demoBlazeHomePage = new HomePage(driver);

      demoBlazeHomePage.visit();
    }


    @Test
    void loginIncorrecto() {
        String user = "fran";
        String pass = "fake";
        String textoExperado = "Wrong password.";

        String textAlert = demoBlazeHomePage
                .gotoLogin()
                .loginAs(user, pass)
                .getTextAlert();

        assertEquals(textoExperado,textAlert);
    }
}
