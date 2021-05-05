package utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;

public class TestExecutionWatcher implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshot();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        takeScreenshot();
    }
   //скриншот
    public static void takeScreenshot() {
        Allure.addAttachment("Test Screenshot", new ByteArrayInputStream(Selenide.screenshot(OutputType.BYTES)));
    }
}
