package pages;


import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import utils.Hook;

import java.io.ByteArrayInputStream;


public class BasePage extends Hook {
    protected Logger logger;
    public BasePage() {
        logger = LogManager.getLogger(BasePage.class);
    }

    public static void takeScreenshot() {
        Allure.addAttachment("screenshot", new ByteArrayInputStream(Selenide.screenshot(OutputType.BYTES)));
    }
}
