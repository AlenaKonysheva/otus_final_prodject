package utils;

import config.Resources;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class Driver {
    protected static WebDriver driver;
    public static Logger logger = LogManager.getLogger(Driver.class);
    public static Resources cfg = ConfigFactory.create(Resources.class);

    public static void setUp() {

    }


    public static void setDown(){
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер закрыт");
        }
    }
}
