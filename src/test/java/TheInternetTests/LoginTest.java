package TheInternetTests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTestTestTheInternet {

    @BeforeEach
    void setUp() {
        this.driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    void loginIcorrento() {
        By username = By.id("username");
        By password = By.id("password");
        By loginBtn = By.cssSelector("#login button");
        By message = By.id("flash");

        driver.findElement(username).sendKeys("Fran");
        driver.findElement(password).sendKeys("fakePass");
        driver.findElement(loginBtn).click();

        String texto = driver.findElement(message).getText();

        assertTrue(texto.startsWith("Your username is invalid!"), "El mensaje de error no es el esperado");
    }

//    @Test
//    void loginCorrecto() {
//        final SecureAreaPage securePage = mainPage.goToAuthenticationFormPage()
//                .loginCorrecto("tomsmith", "SuperSecretPassword!");
//
//        String titulo = securePage.getTitulo();
//        String mensaje = securePage.getMensaje();
//
//        assertEquals("Secure Area",titulo, "El titulo de la pagina no coincide");
//        assertTrue(mensaje.startsWith("You logged into a secure area!"), "El mensaje de bienvenida no es el esperado");
//    }
}
