package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:project.properties"})

public interface AuthConfig  extends Config {

    @Key("remoteUrl")
    @DefaultValue("https://hub-cloud.browserstack.com/wd/hub")
    String remoteUrl();

    @Key("key")
    String key();

    @Key("user")
    String user();
}