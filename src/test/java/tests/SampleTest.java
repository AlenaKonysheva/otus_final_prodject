package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import config.Resources;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.aeonbits.owner.ConfigFactory;
import pages.EventsPage;
import pages.MainPage;

import org.junit.jupiter.api.Assertions;
import utils.Driver;

public class SampleTest extends MainPage {
    private MainPage mainPage = new MainPage();
    private EventsPage eventsPage = new EventsPage();
    public static Resources cfg = ConfigFactory.create(Resources.class);

    @Пусть("пользователь заходит на сайт и переходит на вкладку events")
    public void entry() {
        Selenide.open(cfg.urlEpam());
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


    @Когда("пользователь нажимает на Past Events")
    public void clickPastEvents() {
        mainPage
                .clickPastEventsButton();
        logger.info("выбраны прошедшие мероприятия");
    }

    @Тогда("на странице отображаются карточки прошедших мероприятий")
    public void displayOfPastEvents() {
        mainPage
                .clickPastEventsButton();
        logger.info("натажа кнопка прошедших мероприятий");
    }


    @И("выполнена проверка информация о мероприятии в карточке")
    public void checkInformationCard() {

        mainPage
                .selectionOfTheFirstEventCard()      //выбор какую карту проверять
                .checkLanguage()                 //проверка что графа "язык" не пуста
                .checkNameOfEvents()             //проверка что графа "название мероприятия" не пуста
                .checkDateOfEvents()             //проверка что графа "дата мероприятия" в прошлом
                .checkInformationOfREgistration()//проверка что графа  "информация о регистрации" содержит текст Registration closed
                .checkListOfSpikers();           // проверка что графа  " список спикеров" не пуста
        logger.info("выполнена проверка информация о мероприятии в карточке");

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
