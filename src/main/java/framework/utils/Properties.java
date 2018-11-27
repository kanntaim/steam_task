package framework.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.util.Locale;

public class Properties {
    private static Properties ourInstance = null;
    private Configuration config;


    private String url;
    private String webdriverPath;
    private String webdriverName;
    private String browserName;
    private Locale language;

    private Properties() {
        ourInstance = this;
        Configurations configs = new Configurations();
        try {
            String propertiesPath = System.getProperty("propertiesFilePath");
            propertiesPath = "src/resources/.properties";
            File propertiesFile = new File(propertiesPath);
            System.out.println(propertiesFile.isFile());
            config = configs.properties(propertiesFile);
        } catch (Throwable cex) {
            cex.printStackTrace();
        }
        if (config != null) {
            url = config.getString("url");//todo redo fields into methods
            webdriverPath = config.getString("webdriverPath");
            webdriverName = config.getString("webdriverName");
            browserName = config.getString("browserName");
            language = new Locale(config.getString("language"));
        } else {
            System.out.println("Couldn't read configurations");
        }
    }

    public static Properties getInstance() {
        if (ourInstance == null){
            return new Properties();
        }
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

    public String getBrowserDownloadDirectory(){
        return config.getString("downloadDir");
    }

    public Locale getLanguage() {
        return language;
    }

}
