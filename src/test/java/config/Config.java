package config;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Config {
    private static String browserName;
    private static Logger logger = LogManager.getLogger(Config.class);
    static Resources resources = ConfigFactory.create(Resources.class);
//выбор браузера
    public static void init() {
        try {
            browserName = System.getProperty("browser").trim().toLowerCase();
        } catch (Exception exception) {
            logger.info("по умолчанию будет запущен Chrome.");
            browserName = "chrome";
        }
        logger.info("BROWSER = " + browserName);


        if (browserName.equals(Browsers.CHROME)) {
            com.codeborne.selenide.Configuration.browser = Browsers.CHROME;
            com.codeborne.selenide.Configuration.browserVersion = "90.0";
        } else if (browserName.equals(Browsers.FIREFOX)) {
            com.codeborne.selenide.Configuration.browser = Browsers.FIREFOX;
            com.codeborne.selenide.Configuration.browserVersion = "88.0";
        }


        com.codeborne.selenide.Configuration.startMaximized = true;

        Configuration.baseUrl = resources.urlEpam();
    }
}
