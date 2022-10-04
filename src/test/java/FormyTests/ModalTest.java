package FormyTests;

import org.junit.jupiter.api.Test;
import pages.formy.ModalPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModalTest extends BaseTestFormyTest {

    @Test
    public void testModal() {
        ModalPage page = new ModalPage(driver);
        page.navigateTo();

        page.openModal();

        final String modalTittle = page.getModalTittle();

        assertEquals(modalTittle, "Modal title", "El titulo no coincide");
    }
}
