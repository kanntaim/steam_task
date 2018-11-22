package cases;

import framework.drivers.WebDriver;
import framework.utils.Properties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSteam {
    private Properties properties = Properties.getInstance();
    private String url = properties.getUrl();
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty(properties.getWebdriverName(), properties.getWebdriverPath());
        driver = WebDriver.getInstance();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void testCaseDownloadSteam(){

    }
}
