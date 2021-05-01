package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import pages.EventsPage;
import pages.MainPage;

import org.junit.jupiter.api.Assertions;
import utils.Driver;

public class SampleTest extends MainPage {
    private MainPage mainPage = new MainPage();
    private EventsPage eventsPage = new EventsPage();


    @Пусть("пользователь заходит на сайт и переходит на вкладку events")
    public void entry() {
        Selenide.open(Configuration.baseUrl);
        mainPage
                .acceptCookie()
                .openEvents();
        logger.info("Выполнен переход на вкладуку events ");
    }

    @И("на странице отображаются карточки предстоящих мероприятий")
    public void displayOfUpcomingEvents() {
        mainPage
                .clickUpcomingEvents();
        logger.info("натажа кнопка предстоящих мероприятий");
    }

    @Тогда("количество карточек равно счетчику на кнопке Upcoming Events")
    public void assertUpcomingEvents() {
        Assertions.assertEquals(eventsPage.getUpcomingEventsCount(),
                String.valueOf(eventsPage.getEventsCardsCount()));
        logger.info("Выполнена проверка количества карточек, оно равно счетчику на кнопке");
    }

    @Before()
    public void setUpDriver() {
        Driver.setUp();
    }

    @After()
    public void setDownDriver() {
        Driver.setDown();
    }
}
