package TheInternetTests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.theinternet.HoversPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HoverTest extends BaseTestTestTheInternet {

    @Test
    @DisplayName("Comprobar que los datos del usuario 2 son correctos")
    public void testDatosCorrectorUsuario2() {
        final HoversPage hoversPage = mainPage.goToHoverPage();
        int userPosition = 1;
        final String userName = "name: user2";

        hoversPage.hoverUser(userPosition);

        final String actualUserName = hoversPage.getUserName(userPosition);

        assertTrue(hoversPage.isUserCaptionDisplayed(userPosition));
        assertEquals(userName, actualUserName, "El nombre del usuario 2 no es correcto");
    }
}
