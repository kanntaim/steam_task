package cases;

import framework.drivers.WebDriver;
import framework.utils.Properties;
import framework.utils.Waiter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private Properties properties = Properties.getInstance();
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
        System.setProperty(properties.getWebdriverName(), properties.getWebdriverPath());
        driver = WebDriver.getInstance();
        driver.get(properties.getUrl());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public abstract void test();

    public void assertTrue(boolean statement){
        Assert.assertTrue(statement);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
