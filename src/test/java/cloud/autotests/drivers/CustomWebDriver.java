package cloud.autotests.drivers;

import cloud.autotests.config.AuthConfig;
import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import cloud.autotests.config.WebDriverConfig;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomWebDriver implements WebDriverProvider {

    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    WebDriverConfig driverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();
        //caps.setCapability("browserstack.user", authConfig.user());
       // caps.setCapability("browserstack.key", authConfig.key());
        caps.setCapability("browserstack.user", "bsuser_Q76MrL");
        caps.setCapability("browserstack.key", "vwuqR9y2sc1mBA4UGNQZ");
        caps.setCapability("app", driverConfig.app());
        caps.setCapability("device", driverConfig.device());
        caps.setCapability("os_version", driverConfig.osVersion());
        caps.setCapability("project", driverConfig.project());
        caps.setCapability("build", driverConfig.build());
        caps.setCapability("name", driverConfig.name());

        try {
            return new RemoteWebDriver(
                    new URL(authConfig.remoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}