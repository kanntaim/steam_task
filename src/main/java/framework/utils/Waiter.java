package framework.utils;

import framework.drivers.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Waiter {
    private static long defaultTimeoutMillis;
    private static long defaultPollingRateMillis;


    public static void waitElement(By locator) {
        Properties properties = Properties.getInstance();
        defaultPollingRateMillis = Long.parseLong(properties.getDefaultPollingRateMillis());
        defaultTimeoutMillis = Long.parseLong(properties.getDefaultTimeoutMillis());
        waitElement(locator, defaultTimeoutMillis, defaultPollingRateMillis);
    }

    public static void waitElement(By locator, long timeoutMillis, long pollingEveryMillis) {
        WebDriver driver = WebDriver.getInstance();
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(timeoutMillis))
                .pollingEvery(Duration.ofMillis(pollingEveryMillis))
                .ignoring(NoSuchElementException.class);
        wait.until(driver1 -> driver1.findElement(locator));
    }

    public static List<WebElement> waitElements(By locator) {
        WebDriver driver = WebDriver.getInstance();
        return driver.findElements(locator);
    }

    public static void waitForFileDownloaded(File file) {
        waitForFileDownloaded(file, defaultTimeoutMillis, defaultPollingRateMillis);
    }

    private static void waitForFileDownloaded(File file, long timeoutMillis, long pollingEveryMillis) {
        WebDriver driver = WebDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), timeoutMillis, pollingEveryMillis);
        wait.until(driver1 -> false);
    }
}
