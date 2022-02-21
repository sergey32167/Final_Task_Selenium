package core;

import driver.DriverName;
import driver.DriverPopulator;
import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public static WebDriver getDriverInstance() {
        if (WebDriverSingleton.getDriver() == null) {
            threadLocal.set(createDriver());
        }
        return WebDriverSingleton.getDriver();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;
        if (threadLocal.get() != null) {
            return threadLocal.get();
        }
        String browserName = ReadProperties.getInstance().getBrowserName();
        switch (Browsers.getBrowser(browserName)) {
            case CHROME:
                driver = new DriverPopulator().driverPopulatorChrome(DriverName.LOCAL);
                break;
            case FIREFOX:
                driver = new DriverPopulator().driverPopulatorFF(DriverName.LOCAL);
                break;

            default:
                System.out.println("Browser " + browserName + " is not supported.");
        }
        threadLocal.set(driver);
        return driver;
    }

    public static void cleanCookies() {
        getDriverInstance().manage().deleteAllCookies();
        getDriverInstance().navigate().refresh();
    }

    public static void quit() {
        getDriverInstance().quit();
        threadLocal.set(null);
    }
}