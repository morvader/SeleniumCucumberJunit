package TheInternetTests;

import org.junit.jupiter.api.Test;
import pages.theinternet.AuthenticationFormPage;
import pages.theinternet.SecureAreaPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest extends BaseTestTestTheInternet {

    @Test
    void loginIncorrecto() {
        AuthenticationFormPage authenticationFormPage = mainPage.goToAuthenticationFormPage();
        authenticationFormPage.loginIncorrecto("Fran", "fakePass");
        String texto = authenticationFormPage.getMessageText();
        assertTrue(texto.startsWith("Your username is invalid!"), "El mensaje de error no es el esperado");
    }

    @Test
    void loginCorrecto() {
        final SecureAreaPage securePage = mainPage.goToAuthenticationFormPage()
                .loginCorrecto("tomsmith", "SuperSecretPassword!");

        String titulo = securePage.getTitulo();
        String mensaje = securePage.getMensaje();

        assertEquals(titulo, "Secure Area", "El titulo de la pagina no coincide");
        assertTrue(mensaje.startsWith("You logged into a secure area!"), "El mensaje de bienvenida no es el esperado");
    }
}
