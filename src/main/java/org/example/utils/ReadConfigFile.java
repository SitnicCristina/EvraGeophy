package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
    protected InputStream input = null;
    protected Properties prop = null;

    public ReadConfigFile() {
        try {
            input = ReadConfigFile.class.getClassLoader().getResourceAsStream("config.properties");
            prop = new Properties();
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        if (prop.getProperty("browser") == null)
            return "";
        return prop.getProperty("browser");
    }

    public String getBaseUrl() {
        if (prop.getProperty("BASE_URL") == null)
            return "";
        return prop.getProperty("BASE_URL");
    }

    public String getGoogleEmail() {
        if (prop.getProperty("googleEmail") == null)
            return "";
        return prop.getProperty("googleEmail");
    }

    public String getGoogleEmailPass() {
        if (prop.getProperty("googleEmailPass") == null)
            return "";
        return prop.getProperty("googleEmailPass");
    }

}
