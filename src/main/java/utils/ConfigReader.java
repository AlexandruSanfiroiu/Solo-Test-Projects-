package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties= new Properties();;

    // for static block
    static {

        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in resources");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getUsername() {
        String username = properties.getProperty("username");
        if (username == null) throw new RuntimeException("Username not defined in config.properties");
        return username;
    }

    public static String getPassword() {
        String password = properties.getProperty("password");
        if (password == null) throw new RuntimeException("Password not defined in config.properties");
        return password;
    }
}