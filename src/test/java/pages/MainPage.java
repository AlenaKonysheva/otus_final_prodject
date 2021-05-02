package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import utils.Driver;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends EventsPage {

    //private final SelenideElement eventsLink = $("li.events-icon a");
    private final SelenideElement eventsLink = $("div#app > header > div > div > ul > li:nth-of-type(2) > a");
    private final SelenideElement acceptCookiesButton = $("button#onetrust-accept-btn-handler");
    private final SelenideElement pastEventsButton = $(".evnt-tab-text desktop");

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
}
