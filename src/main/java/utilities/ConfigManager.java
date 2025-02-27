package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties = new Properties();

    // Static block to load the properties file
    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    // Direct access to frequently used properties as constants
    public static final String VALID_LOGIN_URL = properties.getProperty("loginPageURL");
    public static final String USERNAME = properties.getProperty("userName");
    public static final String PASSWORD = properties.getProperty("passWord");

//    public static final String INVALID_LOGIN_URL = properties.getProperty("invalid.login.url");
}
