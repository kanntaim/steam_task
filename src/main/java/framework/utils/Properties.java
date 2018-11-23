package framework.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Properties {
    private static Properties ourInstance = new Properties();
    Configurations configs = new Configurations();
try
    {
        Configuration config = configs.properties(new File("config.properties"));
        // access configuration properties
    }
catch (
    ConfigurationException cex)
    {
        // Something went wrong
    }

    private String url;
    private String webdriverPath;
    private String webdriverName;
    private String browserName;
    private String language;

    private Properties() {
        String propertiesPath = System.getProperty("propertiesFilePath");
        try (BufferedReader propertyReader = new BufferedReader(new FileReader(propertiesPath))) {
            String line;
            while ((line = propertyReader.readLine()) != null) {
                String[] property = line.split("=");
                String propertyName = property[0];
                String propertyValue = property[1];
                switch (propertyName) {
                    case "url":
                        url = propertyValue;
                        break;
                    case "webdriverPath":
                        webdriverPath = propertyValue;
                        break;
                    case "webdriverName":
                        webdriverName = propertyValue;
                        break;
                    case "browserName":
                        browserName = propertyValue;
                        break;
                    case "language":
                        language = propertyValue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getInstance() {
        return ourInstance;
    }

    public String getUrl() {
        return url;
    }

    public String getWebdriverPath() {
        return webdriverPath;
    }

    public String getWebdriverName() {
        return webdriverName;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getLanguage(){return language;}

}
