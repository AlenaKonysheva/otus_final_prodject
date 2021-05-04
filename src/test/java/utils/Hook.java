package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.EventsPage;
import pages.MainPage;

public class Hook {


    @BeforeEach
    public void beforeTest() {
        Selenide.clearBrowserCookies();
        Selenide.open(Configuration.baseUrl);
    }

    @BeforeAll
    public static void setUp() {
        Config.init();
    }
}
