package framework.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

import java.io.File;
import java.util.Locale;

public class Properties {
    private static Properties ourInstance = null;
    private Configuration config;


    private Properties() {
        ourInstance = this;
        Configurations configs = new Configurations();
        try {
            String propertiesPath = System.getProperty("propertiesFilePath");
            File propertiesFile = new File(propertiesPath);
            System.out.println(propertiesFile.isFile());
            config = configs.properties(propertiesFile);
        } catch (Throwable cex) {
            cex.printStackTrace();
        }
    }

    public static Properties getInstance() {
        if (ourInstance == null) {
            return new Properties();
        }
        return ourInstance;
    }

    public String getUrl() {
        return config.getString("url");
    }

    public String getWebdriverPath() {
        return config.getString("webdriverPath");
    }

    public String getWebdriverName() {
        return config.getString("webdriverName");
    }

    public String getBrowserName() {
        return config.getString("browserName");
    }

    public String getBrowserDownloadDirectory() {
        return config.getString("downloadDir");
    }

    public Locale getLanguage() {
        return new Locale(config.getString("language"));
    }

    public String getAgeCheckBirthDate(){return config.getString("ageCheckBirthDate");}

}
