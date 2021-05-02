package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import utils.Driver;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends EventsPage {

    //private final SelenideElement eventsLink = $("li.events-icon a");
    private final SelenideElement eventsLink = $(".events-icon");
    private final SelenideElement acceptCookiesButton = $("id#onetrust-accept-btn-handler");

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

    public MainPage clickUpcomingEvents(){
        eventsLink.click();
        return this;
    }

}
