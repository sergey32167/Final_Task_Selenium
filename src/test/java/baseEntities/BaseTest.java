package baseEntities;

import core.ReadProperties;
import core.Watcher;
import core.WebDriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(Watcher.class)
public abstract class BaseTest {
protected ReadProperties properties;

    public BaseTest() {
        this.properties = ReadProperties.getInstance();
    }

    @AfterEach
    void clean() {
        WebDriverSingleton.cleanCookies();
    }

    @AfterAll
    static void closeDriver() {
        WebDriverSingleton.quit();
    }
}