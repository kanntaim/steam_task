package framework.utils;

import framework.drivers.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
     public static void wait(WebDriver driver, WebElement element, long timeoutMillis, long pollingEveryMillis){
        FluentWait wait = new FluentWait(driver.getDriver())
                .withTimeout(Duration.ofMillis(timeoutMillis))
                .pollingEvery(Duration.ofMillis(pollingEveryMillis));

    }
}
