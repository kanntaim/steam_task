package framework.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LanguageProperties {

    private static LanguageProperties ourInstance = new LanguageProperties();

    private ResourceBundle config;

    private LanguageProperties() {
        Properties properties = Properties.getInstance();
        setConfig(properties.getLanguage());
    }

    public static LanguageProperties getInstance() {
        return ourInstance;
    }

    public void setConfig(Locale locale) {
        try {
            String path = System.getProperty("localePropertiesDirectoryPath");
            File file = new File(path);
            URL[] urls = {file.toURI().toURL()};
            ClassLoader loader = new URLClassLoader(urls);
            config = ResourceBundle.getBundle("steam", locale, loader);
        } catch (IOException | MissingResourceException e) {
            e.printStackTrace();
        }
    }

    public String getButtonInstall() {
        return config.getString("buttonInstall");
    }

    public String getComboboxLanguage() {
        return config.getString("comboboxLanguage");
    }
}
