package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:project.properties"})

public interface AuthConfig  extends Config {

    @Key("remoteUrl")
    @DefaultValue("https://hub-cloud.browserstack.com/wd/hub")
    String remoteUrl();

    @Key("browserstack.key")
    String key();

    @Key("browserstack.user")
    String user();
}