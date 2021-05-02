package utils;

import config.Resources;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    protected static WebDriver driver;
    public static Logger logger = LogManager.getLogger(Driver.class);
    public static Resources cfg = ConfigFactory.create(Resources.class);

    public static void setUp() {
    //    WebDriverManager.chromedriver().setup();
     //   driver = new ChromeDriver();
     //   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     //   driver.manage().window().maximize();
     //   logger.info("Драйвер поднят");
    }


    public static void setDown(){
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер закрыт");
        }
    }
}
