package cloud.autotests.helpers;

import cloud.autotests.config.AuthConfig;

import org.aeonbits.owner.ConfigFactory;
import static io.restassured.RestAssured.given;

public class BrowserstackVideoHelper {

    public static String videoUrl(String sessionId) {

        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

         AuthConfig aConf = ConfigFactory.create(AuthConfig.class, System.getProperties());

        return given()
                .auth().basic(aConf.user(), aConf.key())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
