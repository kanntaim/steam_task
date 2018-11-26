package cases;

import framework.drivers.WebDriver;
import framework.utils.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private Properties properties = Properties.getInstance();
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty(properties.getWebdriverName(), properties.getWebdriverPath());
        driver = WebDriver.getInstance();
        driver.get(properties.getUrl());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public abstract void test();

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
