package com.javaselenium.utilities;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop = new Properties();

    static {
        try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is != null) prop.load(is);
            else throw new RuntimeException("config.properties not found in resources");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(prop.getProperty(key));
    }
}
