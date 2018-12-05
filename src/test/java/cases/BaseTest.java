package cases;

import framework.drivers.WebDriver;
import framework.utils.LanguageProperties;
import framework.utils.Properties;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private Properties properties = Properties.getInstance();
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        properties = Properties.getInstance();
        File downloadDir = properties.getBrowserDownloadDirectory();
        try {
            FileUtils.cleanDirectory(downloadDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        languageProperties.setConfig(new Locale("ru"));
        System.setProperty(properties.getWebdriverName(), properties.getWebdriverPath());
        driver = WebDriver.getInstance();
        driver.get(properties.getUrl());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    private void runTest() {
        test();
    }

    public abstract void test();

    void assertTrue(boolean statement) {
        Assert.assertTrue(statement);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
