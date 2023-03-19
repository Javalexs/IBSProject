package config;
import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:${env}.properties",
        "classpath:local.properties"
})

public interface ProjectConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://ibs.ru")
    String getBaseUrl();

    @Key("browserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("name")
    String getName();

    @Key("lastName")
    String getLastName();
    @Key("link")
    String getLink();

    @Key("email")
    String getEmail();

    @Key("phone")
    String getPhone();

    @Key("phrase")
    String getPhrase();

}
