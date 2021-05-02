package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import javafx.beans.binding.Bindings;
import org.apache.commons.lang3.ArrayUtils;
import org.assertj.core.api.SoftAssertions;

import static com.codeborne.selenide.Selenide.*;


public class EventsPage extends BasePage {

    private final SelenideElement upComingEventsCount = $x("//span[contains(text(), 'Upcoming')]/following-sibling::span[contains(@class, 'evnt-tab-counter')]");
    private final ElementsCollection eventsCardsCount = $$("div.evnt-event-card");
    private final SelenideElement firstEventCard = $("div#app > div > main > section:nth-of-type(3) > div > div > div:nth-of-type(2) > div > div > div > div > div");
    private final SelenideElement languageOfTheEvent = $("section#home > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2)");
    private final SelenideElement nameOfTheEvent = $("section#home > div > div:nth-of-type(2) > div > div > div > div > h1");
    private final SelenideElement dateOfTheEvent = $("section#home > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div > span");
    private final SelenideElement recordingOfEvent = $("section#home > div > div:nth-of-type(2) > div > div > div > div:nth-of-type(2) > div > button");


    public String getUpcomingEventsCount() {
        return upComingEventsCount.getText();
    }

    public int getEventsCardsCount() {
        return eventsCardsCount.size();
    }

    //выбор первой карточки для проверки
    public void selectionOfTheFirstEventCard() {
        firstEventCard.click();
    }

    public String checkLanguage() {
        return languageOfTheEvent.getText();
    }


    public String checkNameOfEvent() {
        return nameOfTheEvent.getText();
    }

    public String  checkDateOfEvent() {
        return dateOfTheEvent.getText();
    }

    public String  checkInformationOfRegistration() {
        return recordingOfEvent.getText();


    }



}



