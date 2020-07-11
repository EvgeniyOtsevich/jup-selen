package test;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:dev.properties"})
public interface MyAppConfig extends Config {

    @Key("url.base")
    String baseUrl();

    @Key("hub.url")
    String hubUrl();

}
