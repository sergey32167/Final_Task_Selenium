package baseEntities;

import core.WebDriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

public abstract class BaseTest {

    @AfterEach
    void clean() {
        WebDriverSingleton.cleanCookies();
    }

    @AfterAll
    static void closeDriver() {
        WebDriverSingleton.quit();
    }
}
