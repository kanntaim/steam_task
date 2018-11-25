package framework.utils;

import framework.drivers.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Waiter {
    public static WebElement wait(By locator, long timeoutMillis, long pollingEveryMillis) {
        WebDriver driver = WebDriver.getInstance();
        Wait wait = new FluentWait<>(driver.getDriver())
                .withTimeout(Duration.ofMillis(timeoutMillis))
                .pollingEvery(Duration.ofMillis(pollingEveryMillis))
                .ignoring(NoSuchElementException.class);
        return (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
        }
        });


    }
}
