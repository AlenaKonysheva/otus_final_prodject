package tests;


import com.codeborne.selenide.Selenide;
import config.Resources;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Epic;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import pages.EventsPage;
import pages.MainPage;
import org.junit.jupiter.api.Assertions;

import java.util.Date;


@Epic("Тесты на страницу мероприятий сайта epam.com")
@DisplayName("Тесты на страницу мероприятий сайта epam.com")
public class SampleTest extends MainPage {
    private MainPage mainPage = new MainPage();
    private EventsPage eventsPage = new EventsPage();
    public static Resources cfg = ConfigFactory.create(Resources.class);
    protected SoftAssertions softAssertions;

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
        logger.info("нажата кнопка предстоящих мероприятий");

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
        //mainPage.clickPastEventsButton();
        logger.info("нажата кнопка прошедших мероприятий");
    }

    @И("выполнена проверка информация о мероприятии в карточке")
    public void checkInformationCard() {

        eventsPage.selectionOfTheFirstEventCard(); //выбор первой карточки для проверки
        eventsPage.checkLanguage();    //проверка, что графа "язык" не пуста
        Assert.assertNotNull(checkLanguage());
        logger.info("выполнена проверка указания языка мероприятия в карточке о мероприятии");


        eventsPage.checkNameOfEvent();//проверка, что графа "название мероприятия" не пуста
        Assert.assertNotNull(checkNameOfEvent());
        logger.info("выполнена проверка наличия названия мероприятия в карточке о мероприятии");

        eventsPage.checkDateOfEvent(); //проверка, что графа "дата мероприятия" не пуста
        Assert.assertNotNull(checkDateOfEvent());
        logger.info("выполнена проверка наличия названия мероприятия в карточке о мероприятии");

        eventsPage.checkInformationOfRegistration();//проверка, что графа 'Watch recording' присутствует
        String actualLink = checkInformationOfRegistration();
        String expectedLink = "Watch recording";
        Assert.assertEquals(actualLink, expectedLink);
        logger.info("выполнена проверка наличия записи мероприятия в карточке о мероприятии");


    }

    @И("выполнена проверка даты предстоящего мероприятия")
    public void checkDataEvents() {
        String dateString;
        Date dateCard;
        Date dateNow = new Date();
        softAssertions = new SoftAssertions();
        // если дата одна - она должна быть больше или рана текущей дате
        // если указан диапазон дат - вторая дата должна быть меньше или равна текущей дате

        dateString = eventsPage.getCardDateFromPage();//получение даты проведения первого предстоящего мероприятия
        dateCard = eventsPage.getDateFromString(dateString);
        softAssertions.assertThat(dateCard.getDate()).isGreaterThanOrEqualTo(dateNow.getDate());
        logger.info("выполнена проверка даты предстоящего мероприятя");
    }

    @И("пользователь нажимает на Location в блоке фильтров")
    public void clickLocation() {
        mainPage
                .clickLocationButton();
        logger.info("нажата кнопка Location в блоке фильтров");
    }

    @И("выбирает Canada в выпадающем списке")
    public void chooseCanada() {
        mainPage
                .clickChooseCanada();
        logger.info("выбран чек-бокс Canada в блоке фильтров");
    }

    /*  @Тогда("на странице отображаются карточки прошедших мероприятий")
      public void displayOfPastEventsInCanada() {
          mainPage
                  .selectionOfTheFirstEventCardInCanada();
          logger.info("");
      }
  */
    @И("выполнена проверка количества карточек равное счетчику на кнопке Past Events")
    public void checkCount() {
        mainPage
                .checkCountPastEventsInCanada();
        logger.info("");
    }


    @И("выполнена проверка даты проведеного мероприятия в Канаде")
    public void checkData() {
        mainPage
                .checkDataPastEventsInCanada();
        logger.info("");
    }


}
