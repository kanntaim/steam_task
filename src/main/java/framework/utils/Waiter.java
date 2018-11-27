package framework.utils;

import framework.drivers.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Waiter {
    public static WebElement waitElement(By locator, long timeoutMillis, long pollingEveryMillis) {
        WebDriver driver = WebDriver.getInstance();
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(timeoutMillis))
                .pollingEvery(Duration.ofMillis(pollingEveryMillis))
                .ignoring(NoSuchElementException.class);
        return wait.until(driver1 -> driver1.findElement(locator));
    }
    public static List<WebElement> waitElements(By locator, long timeoutMillis, long pollingEveryMillis){
        WebDriver driver = WebDriver.getInstance();
        return driver.findElements(locator);
    }
}
