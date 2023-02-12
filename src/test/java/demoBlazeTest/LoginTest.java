package demoBlazeTest;

import Base.BaseTest;

import okhttp3.*;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoblaze.HomePage;

import java.io.IOException;

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

    @Test
    void loginCorrecto() {
        String user = "franQA";
        String pass = "1234";
        String textoExperado = "Welcome " +  user;

        String textUserName = demoBlazeHomePage
                .gotoLogin()
                .loginAs(user, pass)
                .getUserName();

        assertEquals(textoExperado,textUserName);
    }

    @Test
    void loginCorrecto_APICall() throws IOException {
        String user = "franQA";
        String pass = "1234";
        String textoExperado = "Welcome " +  user;

        String body = "{\n" +
                "  \"username\": \"franQA\",\n" +
                "  \"password\": \"MTIzNA==\"\n" +
                "}";

        String userToken = this.post("https://api.demoblaze.com/login", body);

        Cookie cookie = new Cookie("tokenp_", userToken);
        driver.manage().addCookie(cookie);

        driver.navigate().refresh();

        String textUserName = demoBlazeHomePage.getUserName();

        assertEquals(textoExperado,textUserName);
    }

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string().replace("Auth_token: ","" )
                    .replace("\n", "")
                    .replace("\"", "");
        }
    }
}
