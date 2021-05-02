package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.*;


public class EventsPage extends BasePage {
    protected WebDriver driver;
    private final SelenideElement upComingEventsCount = $("div#app > div > main > section:nth-of-type(3) > div > div > div > ul > li > a > span:nth-of-type(3)");
    private final ElementsCollection eventsCardsCount = $$("div.evnt-event-card");
    private final SelenideElement firstEventCard = $("div#app > div > main > section:nth-of-type(3) > div > div > div:nth-of-type(2) > div > div > div > div > div");
    private final SelenideElement languageOfTheEvent = $("section#home > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2)");
    private final SelenideElement nameOfTheEvent = $("section#home > div > div:nth-of-type(2) > div > div > div > div > h1");
    private final SelenideElement dateOfTheEvent = $("section#home > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div > span");
    private final SelenideElement recordingOfEvent = $("section#home > div > div:nth-of-type(2) > div > div > div > div:nth-of-type(2) > div > button");

    @Step("получение количества предстоящих мероприятий")
    public String getUpcomingEventsCount() {
        return upComingEventsCount.getText();//получение текста
    }

    @Step("получение количества карточек мероприятий")
    public int getEventsCardsCount() {
        return eventsCardsCount.size();//получение массива

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


}



