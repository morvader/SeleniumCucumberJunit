package TheInternetTests;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DropdownTest extends BaseTestTestTheInternet {

    @Test
    void checkOptions() {
        final List<String> options = mainPage.goToDropDownPage().getOptions();

        assertEquals(2, options.size(), "El número de opciones no es correcto");
    }

    @Test
    void selectFirstOption() {
        String expected = "Option 1";

        String selected = mainPage.goToDropDownPage()
                .selectOption(1)
                .getSelectedOption();

        assertEquals(expected, selected, "Opcion Incorrecta");
    }


    private static Object[][] createData1() {
        return new Object[][]{
                {"1", "Option 1"},
                {"2", "Option 2"},
        };
    }


    @ParameterizedTest
    @MethodSource("createData1")
    public void testAllOptions(String index, String texto) {
        String expected = texto;

        String selected = mainPage.goToDropDownPage()
                .selectOption(Integer.parseInt(index))
                .getSelectedOption();

        assertEquals(expected, selected, "Opcion Incorrecta");
    }

}
