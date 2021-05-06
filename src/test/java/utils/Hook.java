package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.BasePage;
import pages.EventsPage;
import pages.MainPage;


@ExtendWith(TestExecutionWatcher.class)
public class Hook {
    protected BasePage basePage;
    protected MainPage mainPage;
    protected EventsPage eventsPage;


    @BeforeEach
    public void beforeTest() {
        Selenide.clearBrowserCookies();
        Selenide.open(Configuration.baseUrl);
        basePage = new BasePage();
        mainPage = new MainPage();
        eventsPage = new EventsPage();

    }

    @BeforeAll //выбор браузера
    public static void setUp() {
        Config.init();
    }

    @AfterEach
    public void setDown() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();


    }

}
