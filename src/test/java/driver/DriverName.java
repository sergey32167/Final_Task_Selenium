package driver;

public enum DriverName {
    LOCAL("local"),
    SAUCE("sauce"),
    GRID("grid");

    private final String name;

    DriverName(String name) {
        this.name = name;
    }

    public static DriverName getDriverName(String name) {
        for (DriverName driverName : values()) {
            if (driverName.name.equalsIgnoreCase(name)) {
                return driverName;
            }
        }
        throw new RuntimeException("DriverName not found!!!");
    }
}
