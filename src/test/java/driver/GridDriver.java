package driver;

import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDriver implements GetDriver{

    @Override
    public WebDriver initChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        return new RemoteWebDriver(gridUrl(), chromeOptions);
    }

    @Override
    public WebDriver initFFDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new RemoteWebDriver(gridUrl(), firefoxOptions);
    }

    private URL gridUrl() {

        String url = "https://" + ReadProperties.getInstance().getGridHost() + ":" + ReadProperties.getInstance().getGridPort();
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
