package driver;

import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SauceLabsDriver implements GetDriver{

    @Override
    public WebDriver initChromeDriver() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);
        return new RemoteWebDriver(sauceURL(), browserOptions);
    }

    @Override
    public WebDriver initFFDriver() {
        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);
        return new RemoteWebDriver(sauceURL(), browserOptions);
    }

    private URL sauceURL() {
        String url = "https://" + ReadProperties.getInstance().getSauceName() + ":" + ReadProperties.getInstance().getSauceKey() + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
