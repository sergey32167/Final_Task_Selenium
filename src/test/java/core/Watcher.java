package core;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.lang.reflect.Method;

public class Watcher implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable cause) {
        Method method = extensionContext.getRequiredTestMethod();
        makeScreenshotOnFailure(method.getName());
        WebDriverSingleton.quit();
    }

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable cause) {
        WebDriverSingleton.quit();
    }

    @Attachment(value = "{testName} - screenshot", type = "image/png")
    private byte[] makeScreenshotOnFailure(String testName) {
        return ((TakesScreenshot) WebDriverSingleton.getDriverInstance()).getScreenshotAs(OutputType.BYTES);
    }
}
