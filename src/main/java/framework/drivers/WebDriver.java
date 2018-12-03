package framework.drivers;

import framework.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebDriver {

    private static WebDriver ourInstance = null;
    private org.openqa.selenium.WebDriver driver;

    private WebDriver() {
        ourInstance = this;
        Properties properties = Properties.getInstance();
        String browserName = properties.getBrowserName();
        String downloadDir = properties.getBrowserDownloadDirectory();
        String downloadDirNew = new String(downloadDir.getBytes(Charset.forName("windows-1252")), Charset.forName("windows-1251"));
        switch (browserName) {
            case "Firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("browser.download.folderList", 2);
                firefoxOptions.addPreference("browser.download.dir", downloadDirNew);
                firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
                        "application/octet-stream;");
                firefoxOptions.addPreference("browser.download.manager.showWhenStarting", false);
                firefoxOptions.addPreference("pdfjs.disabled", true);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "Chrome":
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", downloadDirNew);
                prefs.put("safebrowsing.enabled", true);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(chromeOptions);
        }
    }

    public static WebDriver getInstance() {
        if (ourInstance == null) {
            ourInstance = new WebDriver();
        }
        return ourInstance;
    }

    private void switchTab(int number) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (number >= 0) {
            driver.switchTo().window(tabs.get(number));
        } else {
            driver.switchTo().window(tabs.get(tabs.size() + number));
        }
    }

    public void returnToMainPage() {
        Properties properties = Properties.getInstance();
        String url = properties.getUrl();
        this.switchTab(0);
        driver.get(url);
        driver.navigate().refresh();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void quit() {
        driver.quit();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void get(String url) {
        driver.get(url);
    }

    public org.openqa.selenium.WebDriver.Options manage() {
        return driver.manage();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public org.openqa.selenium.WebDriver getDriver() {
        return driver;
    }
}
