package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static ReadProperties instance;
    private final Properties properties;

    private ReadProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }

    public String getUsername(){
        return properties.getProperty("username");
    }
    public String getPassword(){
        return properties.getProperty("password");
    }
    public String getBrowserName() {
        return properties.getProperty("browser");
    }
    public String getFirstName() {
        return properties.getProperty("firstname");
    }
    public String getLastName() {
        return properties.getProperty("lastname");
    }
    public String getEmail() {
        return properties.getProperty("email");
    }
    public String getEmail2() {
        return properties.getProperty("email2");
    }
    public String getCompany() {
        return properties.getProperty("company");
    }
    public String getAddress() {
        return properties.getProperty("address");
    }
    public String getCity() {
        return properties.getProperty("city");
    }
    public String getAlias() {
        return properties.getProperty("alias");
    }
    public int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
    public String getZip() {
        return properties.getProperty("zip");
    }
    public String getPhone() {
        return properties.getProperty("phone");
    }
    public String getWishlistName() {
        return properties.getProperty("wishlistname");
    }
    public String getURL() {
        return properties.getProperty("URL");
    }
    public String getGridHost() {
        return properties.getProperty("gridhost");
    }
    public String getGridPort() {
        return properties.getProperty("gridport");
    }
    public String getSauceName() {
        return properties.getProperty("saucename");
    }
    public String getSauceKey() {
        return properties.getProperty("saucekey");
    }
}