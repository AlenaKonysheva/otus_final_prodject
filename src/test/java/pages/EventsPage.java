package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class EventsPage extends BasePage {

    private final SelenideElement upComingEventsCount = $("div#app > div > main > section:nth-of-type(3) > div > div > div > ul > li > a > span:nth-of-type(3)");
    private final ElementsCollection eventsCardsCount = $$("div.evnt-event-card");
    private final SelenideElement firstEventCard = $("div#app > div > main > section:nth-of-type(3) > div > div > div:nth-of-type(2) > div > div > div > div > div");
    private final SelenideElement languageOfTheEvent = $("section#home > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2)");
    private final SelenideElement nameOfTheEvent = $("section#home > div > div:nth-of-type(2) > div > div > div > div > h1");
    private final SelenideElement dateOfTheEvent = $("section#home > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div > span");
    private final SelenideElement recordingOfEvent = $("section#home > div > div:nth-of-type(2) > div > div > div > div:nth-of-type(2) > div > button");
    private final SelenideElement eventCardsDate = $("div#app > div > main > section:nth-of-type(3) > div > div > div:nth-of-type(2) > div > div > div > div > div > a > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div > div > p > span");
    private final SelenideElement eventCardsDateInCanada = $("div#app > div > main > section:nth-of-type(3) > div > div > div:nth-of-type(2) > div > div > div > div > div > a > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div > div > p > span");

    @Step("получение количества предстоящих мероприятий")
    public String getUpcomingEventsCount() {
        return upComingEventsCount.getText();
    }

    @Step("получение количества карточек мероприятий")
    public int getEventsCardsCount() {
        return eventsCardsCount.size();
    }

    @Step("выбор первой карточки для проверки")
    public void selectionOfTheFirstEventCard() {
        firstEventCard.click();
    }

    @Step("получение текста из строки язык мероприятия")
    public String checkLanguage() {

        return languageOfTheEvent.getText();
    }

    @Step("получение текста из строки названия мероприятия")
    public String checkNameOfEvent() {

        return nameOfTheEvent.getText();
    }

    @Step("получение текста из строки дата мероприятия")
    public String checkDateOfEvent() {

        return dateOfTheEvent.getText();
    }

    @Step("получение текста из строки запись мероприятия")
    public String checkInformationOfRegistration() {

        return recordingOfEvent.getText();


    }

    @Step("получение даты проведения первого предстоящего мероприятия")
    public String getCardDateFromPage() {
        return eventCardsDate.getText();
    }

    @Step("преобразование даты выбранного предстоящео мероприятия")
    public Date getDateFromString(String dateString) {
        Date date = null;
        // Если указан диапазон дат, то выбираем вторую дату, которую потом будем сравнивать
        if (dateString.contains("-")) {
            dateString = dateString.split("-")[1];
        }
        try {
            date = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(dateString);
        } catch (ParseException ex) {
            logger.info(ex.getMessage());
        }

        return date;
    }

    @Step("получение даты проведения первого предстоящего мероприятия в Канаде")
    public String getCardDateEventsInCanadaFromPage() {
        return eventCardsDateInCanada.getText();
    }

    @Step("преобразование даты выбранного предстоящео мероприятия в Канаде")
    public Date getDateEventsInCanadaFromString(String dateEventsInCanadaString) {
        Date dataCanada = null;
      //Если указан диапазон дат, то выбираем вторую дату, которую потом будем сравнивать
        if (dateEventsInCanadaString.contains("-")) {
            dateEventsInCanadaString = dateEventsInCanadaString.split("-")[1];
        }
        try {
            dataCanada = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(dateEventsInCanadaString);
        } catch (ParseException ex) {
            logger.info(ex.getMessage());
        }

        return dataCanada;
    }
}



