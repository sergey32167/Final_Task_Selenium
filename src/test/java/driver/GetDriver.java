package driver;

import org.openqa.selenium.WebDriver;

public interface GetDriver {

    WebDriver initChromeDriver();

    WebDriver initFFDriver();
}
