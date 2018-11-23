package framework.utils;

import framework.drivers.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
     public static void wait(WebDriver driver, WebElement element, long timeout, long poll){
        wait = new FluentWait(driver.getDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(timeout))
    }
}
