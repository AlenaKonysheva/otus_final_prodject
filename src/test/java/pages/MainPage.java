package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.SoftAssertions;
import utils.Driver;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends EventsPage {

    private final SelenideElement eventsLink = $("div#app > header > div > div > ul > li:nth-of-type(2) > a");
    private final SelenideElement acceptCookiesButton = $("button#onetrust-accept-btn-handler");
    private final SelenideElement pastEventsButton = $("div#app > div > main > section:nth-of-type(3) > div > div > div > ul > li:nth-of-type(2) > a > span");

    //согласие с куками
    public MainPage acceptCookie() {
        acceptCookiesButton
                .shouldBe(Condition.visible)
                .click();
        return this;

    }

    //выбор вкладки Events
    public MainPage openEvents() {
        eventsLink.click();
        return this;
    }

    //выбор будущих мероприятий
    public MainPage clickUpcomingEvents() {
        eventsLink.click();
        return this;
    }

    //выбор прошедших мероприятий
    public MainPage clickPastEventsButton() {
        pastEventsButton.click();
        return this;

    }




}
