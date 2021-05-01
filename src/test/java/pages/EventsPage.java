package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;


public class EventsPage extends BasePage {
    //   Локаторы
    private final SelenideElement upComingEventsCount = $x("//span[contains(text(), 'Upcoming')]/following-sibling::span[contains(@class, 'evnt-tab-counter')]");
    private final ElementsCollection eventsCardsCount = $$("div.evnt-event-card");


    public String getUpcomingEventsCount() {
        return upComingEventsCount.getText();
    }

    public int getEventsCardsCount(){
        return eventsCardsCount.size();
    }

}



