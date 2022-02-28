package driver;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverPopulator {
    private final Map<DriverName, GetDriver> driverMap;

    public DriverPopulator() {
        this.driverMap = new HashMap<>();
        driverMap.put(DriverName.LOCAL, new LocalDriver());
        driverMap.put(DriverName.GRID, new GridDriver());
        driverMap.put(DriverName.SAUCE, new SauceLabsDriver());
    }

    public WebDriver driverPopulatorChrome(DriverName name) {
        return driverMap.get(name).initChromeDriver();
    }

    public WebDriver driverPopulatorFF(DriverName name) {
        return driverMap.get(name).initFFDriver();
    }
}