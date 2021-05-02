package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import utils.Driver;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends EventsPage {

    private final SelenideElement eventsLink = $("div#app > header > div > div > ul > li:nth-of-type(2) > a");
    private final SelenideElement acceptCookiesButton = $("button#onetrust-accept-btn-handler");
    private final SelenideElement pastEventsButton = $("div#app > div > main > section:nth-of-type(3) > div > div > div > ul > li:nth-of-type(2) > a > span");
    private final SelenideElement firstEventCard = $("div#app > div > main > section:nth-of-type(3) > div > div > div:nth-of-type(2) > div > div > div > div > div");

    public MainPage acceptCookie() {
        acceptCookiesButton
                .shouldBe(Condition.visible)
                .click();
        logger.info("Нажата согласие с cookies во всплывающем окне");
        return this;

    }

    public MainPage openEvents() {
        eventsLink.click();
        return this;
    }

    public MainPage clickUpcomingEvents() {
        eventsLink.click();
        return this;
    }

    public MainPage clickPastEventsButton() {
        pastEventsButton.click();
        return this;

    }

    public MainPage selectionOfTheFirstEventCard() {
        firstEventCard.click();
        return this;
    }

    public MainPage checkLanguage() {
        return this;
    }

    public MainPage checkNameOfEvents() {
        return this;
    }

    public MainPage checkDateOfEvents() {
        return this;
    }

    public MainPage checkInformationOfREgistration() {
        return this;
    }

    public MainPage checkListOfSpikers() {
        return this;
    }
}
