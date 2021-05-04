package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends EventsPage {

    private final SelenideElement eventsLink = $("div#app > header > div > div > ul > li:nth-of-type(2) > a");
    private final SelenideElement acceptCookiesButton = $("button#onetrust-accept-btn-handler");
    private final SelenideElement pastEventsButton = $("div#app > div > main > section:nth-of-type(3) > div > div > div > ul > li:nth-of-type(2) > a > span");
    private final SelenideElement upComingEventsButton = $("div#app > div > main > section:nth-of-type(3) > div > div > div > ul > li > a > span");
    private final SelenideElement locationButton = $("div#filter_location");
    private final SelenideElement canadaButton = $("div#app > div > main > section:nth-of-type(2) > div > div > div > div > div > div:nth-of-type(3) > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(4) > div > div:nth-of-type(2) > label");

    @Step("согласие с куками")
    public MainPage acceptCookie() {
        acceptCookiesButton
                .shouldBe(Condition.visible)
                .click();
        return this;

    }

    @Step("выбор вкладки Events")
    public MainPage openEvents() {
        eventsLink.click();

        return this;
    }

    @Step("выбор будущих мероприятий")
    public MainPage clickUpcomingEvents() {
        upComingEventsButton.click();
        return this;
    }

    @Step("выбор прошедших мероприятий")
    public MainPage clickPastEventsButton() {
        pastEventsButton.click();
        return this;

    }

    @Step("нажатие кнопки Location в блоке фильтров")
    public MainPage clickLocationButton() {
        locationButton.click();
        return this;
    }

    @Step("выбор чек-бокса Canada в блоке фильтров")
    public MainPage clickChooseCanada() {
        canadaButton.click();
        return this;
    }
    @Step("selectionOfTheFirstEventCardInCanada")
    public MainPage selectionOfTheFirstEventCardInCanada() {
        return this;
    }


    @Step("")
    public MainPage checkCountPastEventsInCanada() {
        return this;
    }
    @Step("")
    public MainPage checkDataPastEventsInCanada() {
        return this;
    }



}
