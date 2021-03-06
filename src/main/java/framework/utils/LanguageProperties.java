package framework.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LanguageProperties {

    private static LanguageProperties ourInstance;

    private final String defaultLocalePropertiesPath = "src/main/resources/locale";

    private ResourceBundle config;

    private LanguageProperties() {
        Properties properties = Properties.getInstance();
        setConfig(properties.getLanguage());
    }

    public static LanguageProperties getInstance() {
        if (ourInstance == null) {
            ourInstance = new LanguageProperties();
        }
        return ourInstance;
    }

    public void setConfig(Locale locale) {
        try {
            String path = System.getProperty("localePropertiesDirectoryPath");
            if (path == null) {
                path = defaultLocalePropertiesPath;
            }
            File file = new File(path);
            URL[] urls = {file.toURI().toURL()};
            ClassLoader loader = new URLClassLoader(urls);
            config = ResourceBundle.getBundle("steam", locale, loader);
        } catch (IOException | MissingResourceException e) {
            e.printStackTrace();
        }
    }

    public String getButtonInstall() {
        return getProperty("buttonInstall");
    }

    public String getSeeAllSpecials() {
        return getProperty("seeAllSpecials");
    }

    public String getViewPage() {
        return getProperty("viewPage");
    }

    public String getLanguageComboboxItem() {
        return getProperty("languageComboboxItem");
    }

    public String getProperty(String key) {
        String labelOld = config.getString(key);
        return new String(labelOld.getBytes(Charset.forName("windows-1252")), Charset.forName("windows-1251"));
    }
}
