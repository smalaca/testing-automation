package com.smalaca.bdd.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigPropertiesFactory {

    public static final String CONFIG_PROPERTIES_FILE_NAME = "config.properties";

    public ConfigProperties read() {
        try (InputStream input = configProperties()) {
            Properties properties = new Properties();
            properties.load(input);

            return new ConfigProperties(properties);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private InputStream configProperties() {
        return getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES_FILE_NAME);
    }
}
