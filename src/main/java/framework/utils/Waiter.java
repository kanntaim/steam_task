package framework.utils;

import framework.drivers.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class Waiter {
    public static WebElement wait(WebDriver driver, By locator, long timeoutMillis, long pollingEveryMillis) {
        FluentWait wait = new FluentWait(driver.getDriver())
                .withTimeout(Duration.ofMillis(timeoutMillis))
                .pollingEvery(Duration.ofMillis(pollingEveryMillis));
        return (WebElement) wait.until((Function<WebDriver, WebElement>) driver1 -> driver1.findElement(locator));

    }
}
