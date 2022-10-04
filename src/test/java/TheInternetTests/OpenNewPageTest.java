package TheInternetTests;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenNewPageTest extends BaseTestTestTheInternet {

    @Test
    public void testOpenNewPage() {
        final String text = mainPage.goToHandleWindowsPage()
                .openNewPage()
                .getText();

        assertEquals(text, "New Window", "El texto no coincide");
    }
}
