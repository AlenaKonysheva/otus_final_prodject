package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

public class BasePage {
    protected Logger logger;
    public BasePage() {
        logger = LogManager.getLogger(BasePage.class);
    }

}
