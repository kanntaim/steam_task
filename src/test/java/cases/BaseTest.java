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
            String downloadDirPath = properties.getBrowserDownloadDirectory();
            String downloadDirNew = new String(downloadDirPath.getBytes(Charset.forName("windows-1252")), Charset.forName("windows-1251"));
            File downloadDir = new File(new File(downloadDirNew).getCanonicalPath());
            if(!downloadDir.exists()) {
                if(!new File(downloadDir.getCanonicalPath()).mkdirs()){
                    throw new IOException("couldn't create directory");
                }
            }
            FileUtils.cleanDirectory(downloadDir);
        } catch (IOException | IllegalArgumentException e) {
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
    private void runTest(){
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
