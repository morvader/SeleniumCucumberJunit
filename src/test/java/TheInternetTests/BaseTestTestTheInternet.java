package TheInternetTests;

import Base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import pages.theinternet.MainPage;

public class BaseTestTestTheInternet extends BaseTest {

    protected MainPage mainPage;

    @BeforeEach
    public void setup() {
        super.setup();
        driver.get("https://the-internet.herokuapp.com/");

        mainPage = new MainPage(driver);
    }
}
