package framework.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.util.Locale;

public class Properties {
    private static Properties ourInstance = new Properties();
    private Configuration config;


    private String url;
    private String webdriverPath;
    private String webdriverName;
    private String browserName;
    private Locale language;

    private Properties() {
        Configurations configs = new Configurations();
        try {
            String propertiesPath = System.getProperty("propertiesFilePath");
            config = configs.properties(new File(propertiesPath));
        } catch (ConfigurationException cex) {
            cex.printStackTrace();
        }
        if(config!=null) {
            url = config.getString("url");
            webdriverPath = config.getString("webdriverPath");
            webdriverName = config.getString("webdriverName");
            browserName = config.getString("browserName");
            language = new Locale(config.getString("language"));
        }
        else {
            System.out.println("Couldn't read configurations");
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

    public Locale getLanguage() {
        return language;
    }

}
