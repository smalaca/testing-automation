package com.smalaca.selenium.properties;

import java.util.Properties;

public class ConfigProperties {
    private final Properties properties;

    ConfigProperties(Properties properties) {
        this.properties = properties;
    }

    public String getEdgeWebDriverPath() {
        return properties.getProperty("webdriver.edge.driver");
    }

    public String getFirefoxWebDriverPath() {
        return properties.getProperty("webdriver.gecko.driver");
    }

    public String getChromeWebDriverPath() {
        return properties.getProperty("webdriver.chrome.driver");
    }
}
