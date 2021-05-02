package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Hook;


public class BasePage extends Hook {
    protected Logger logger;
    public BasePage() {
        logger = LogManager.getLogger(BasePage.class);
    }

}
