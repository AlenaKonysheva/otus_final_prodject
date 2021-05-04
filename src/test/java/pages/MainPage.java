package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends EventsPage {

    private final SelenideElement eventsLink = $("div#app > header > div > div > ul > li:nth-of-type(2) > a");
    private final SelenideElement acceptCookiesButton = $("button#onetrust-accept-btn-handler");
    private final SelenideElement pastEventsButton = $("div#app > div > main > section:nth-of-type(3) > div > div > div > ul > li:nth-of-type(2) > a > span");
    private final SelenideElement upComingEventsButton = $("div#app > div > main > section:nth-of-type(3) > div > div > div > ul > li > a > span");
    private final SelenideElement locationButton = $("div#filter_location");
    private final SelenideElement canadaButton = $("div#app > div > main > section:nth-of-type(2) > div > div > div > div > div > div:nth-of-type(3) > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(4) > div > div:nth-of-type(2) > label");
    private final SelenideElement eventInCanadaLink = $("div#app > div > main > section:nth-of-type(3) > div > div > div:nth-of-type(2) > div > div > div > div > div > a > div");
    private final SelenideElement pastEventsInCanadaCount = $x("//span[contains(text(), 'Past')]/following-sibling::span[contains(@class, 'evnt-tab-counter')]");
    private final ElementsCollection eventsCardsInCanadaCount = $$("div#app > div > main > section:nth-of-type(3) > div > div > div:nth-of-type(2) > div > div > div");
    private static final SelenideElement loader = $("div.evnt-global-loader");
    private final SelenideElement moreFilterButton = $("div#app > div > main > section:nth-of-type(2) > div > div > div > div > div > div:nth-of-type(4) > div");
    private final SelenideElement categoryButton=$("div#filter_category");
    private final SelenideElement testingButton=$("div#app > div > main > section:nth-of-type(2) > div > div > div > div > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(16) > div > div:nth-of-type(2) > label");
    private final SelenideElement locationCategoryButton=$("div#filter_location");
    private final SelenideElement belarusButton=$("div#app > div > main > section:nth-of-type(2) > div > div > div > div > div > div:nth-of-type(3) > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div:nth-of-type(2) > div > div:nth-of-type(2) > label");
    private final SelenideElement languageCategoryButton=$("div#filter_language");
    private final SelenideElement englishButton=$("div#collapseMoreFilters > div > div > div:nth-of-type(5) > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(2) > div > div > label");


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

    @Step("ожидание прогрузки страницы мероприятий в Канаде")
    public void waitLoadCard() {
        try {
            loader
                    .shouldBe(Condition.appear)
                    .shouldBe(Condition.disappear);
        } catch (Exception ex) {
        }
    }

    @Step("получение количества прошедших мероприятий в Канаде")
    public int getPastEventsInCanadaCount() {
        return Integer.parseInt(pastEventsInCanadaCount.getText());
    }

    @Step("получение количества карточек прошедших мероприятий в Канаде")
    public int getEventsCardsInCanadaCount() {
        return eventsCardsInCanadaCount.size();
    }

    @Step("нажатие на More Filters")
    public MainPage moreFilter() {
        moreFilterButton.click();
        return this;
    }

    @Step("нажато Category")
    public MainPage clickCategory() {
        categoryButton.click();
        return this;
    }
    @Step("выбрано Testing")
    public MainPage  chooseTesting() {
        testingButton.click();
        return this;
    }

    @Step("нажато Location")
    public MainPage  clickLocationCategory() {
        locationCategoryButton.click();
        return this;
    }


    @Step("выбрано Belarus")
    public MainPage chooseBelarus(){
        belarusButton.click();
        return this;
    }

    @Step("выбрано Language")
    public MainPage  clickLanguage() {
        languageCategoryButton.click();
        return this;
    }

    @Step("выбрано English")
    public MainPage  chooseEnglish() {
        englishButton.click();
        return this;
    }

}
