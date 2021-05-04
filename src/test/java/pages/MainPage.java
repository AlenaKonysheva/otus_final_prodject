package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends EventsPage {

    private final SelenideElement eventsLink = $("div#app > header > div > div > ul > li:nth-of-type(2) > a");
    private final SelenideElement acceptCookiesButton = $("button#onetrust-accept-btn-handler");
    private final SelenideElement pastEventsButton = $("div#app > div > main > section:nth-of-type(3) > div > div > div > ul > li:nth-of-type(2) > a > span");
    private final SelenideElement upComingEventsButton = $("div#app > div > main > section:nth-of-type(3) > div > div > div > ul > li > a > span");
    private final SelenideElement locationButton = $("div#filter_location");
    private final SelenideElement canadaButton = $("div#app > div > main > section:nth-of-type(2) > div > div > div > div > div > div:nth-of-type(3) > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(4) > div > div:nth-of-type(2) > label");
    private final SelenideElement eventInCanadaLink = $("div#app > div > main > section:nth-of-type(3) > div > div > div:nth-of-type(2) > div > div > div > div > div > a > div");
    private final SelenideElement pastEventsInCanadaCount = $("div#app > div > main > section:nth-of-type(3) > div > div > div > ul > li:nth-of-type(2) > a > span:nth-of-type(3)");
    private final ElementsCollection eventsCardsInCanadaCount = $$("div#app > div > main > section:nth-of-type(3) > div > div > div:nth-of-type(2) > div > div > div");

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

    @Step("проверка присутсвия прошедшего мероприятия в Канаде")
    public MainPage selectionOfTheFirstEventCardInCanada() {
        Assert.assertNotNull(eventInCanadaLink);
        return this;
    }


    @Step("получение количества прошедших мероприятий в Канаде")
    public String getPastEventsInCanadaCount() {
        return pastEventsInCanadaCount.getText();
    }

    @Step("получение количества карточек мероприятий в Канаде")
    public int getEventsCardsInCanadaCount() {
        return eventsCardsInCanadaCount.size();
    }

    @Step("выполнена проверка даты проведеного мероприятия в Канаде")
    public MainPage checkDataPastEventsInCanada() {
        return this;
    }


}
