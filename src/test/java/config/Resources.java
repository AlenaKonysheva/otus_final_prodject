package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface Resources extends Config{


    @Config.Key("urlEpam")
    String urlEpam();

    @Config.Key("selenoidUrl")
    String selenoidUrl();
}
