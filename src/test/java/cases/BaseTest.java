package cases;

import framework.drivers.WebDriver;
import framework.utils.LanguageProperties;
import framework.utils.Properties;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private final Properties properties = Properties.getInstance();
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        try {
            Properties properties = Properties.getInstance();
            String downloadDir = properties.getBrowserDownloadDirectory();
            String downloadDirNew = new String(downloadDir.getBytes(Charset.forName("windows-1252")), Charset.forName("windows-1251"));
            FileUtils.cleanDirectory(new File(downloadDirNew));
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

    public abstract void test();//todo ask about this

    void assertTrue(boolean statement) {
        Assert.assertTrue(statement);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
