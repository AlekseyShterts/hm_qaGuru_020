package helpers;

import config.AuthConfig;

import org.aeonbits.owner.ConfigFactory;
import static io.restassured.RestAssured.given;

public class BrowserstackVideoHelper {

    public static String videoUrl(String sessionId) {

        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

        return given()
                .auth().basic(authConfig.user(), authConfig.key())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
