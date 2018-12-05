package framework.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
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

    public File getBrowserDownloadDirectory() {
        String downloadDirPath = config.getString("downloadDir");
        String downloadDirNew = new String(downloadDirPath.getBytes(Charset.forName("windows-1252")), Charset.forName("windows-1251"));
        File downloadDir = null;
        try {
            downloadDir = new File(new File(downloadDirNew).getCanonicalPath());
            if (!downloadDir.exists()) {
                if (!new File(downloadDir.getCanonicalPath()).mkdirs()) {
                    throw new IOException("couldn't create directory");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return downloadDir;
    }

    public String getDownloadedFileName() {
        return config.getString("downloadedFileName");
    }

    public Locale getLanguage() {
        return new Locale(config.getString("language"));
    }

    public String getAgeCheckBirthDate() {
        return config.getString("ageCheckBirthDate");
    }

    public String getDefaultTimeoutMillis() {
        return config.getString("defaultTimeoutMillis");
    }

    public String getDefaultPollingRateMillis() {
        return config.getString("defaultPollingRateMillis");
    }

}
