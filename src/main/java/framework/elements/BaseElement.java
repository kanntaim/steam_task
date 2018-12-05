package framework.elements;

import framework.drivers.WebDriver;
import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    private final WebDriver driver;
    private final By locator;
    private WebElement webElement;

    BaseElement(By locator) {
        this.locator = locator;
        driver = WebDriver.getInstance();
        webElement = driver.findElement(locator);
    }

    BaseElement(WebElement element) {
        locator = null;
        driver = WebDriver.getInstance();
        webElement = element;
    }

    public void click(long timeout, long pollingRate) {
        if (locator != null) {
            Waiter.waitElement(locator, timeout, pollingRate);
            webElement = driver.findElement(locator);
        }
        webElement.click();
    }

    public void click() {
        if (locator != null) {
            Waiter.waitElement(locator);
            webElement = driver.findElement(locator);
        }
        webElement.click();
    }

    public String getText(long timeout, long pollingRate) {
        if (locator != null) {
            Waiter.waitElement(locator, timeout, pollingRate);
            webElement = driver.findElement(locator);
        }
        return webElement.getText();
    }

    public String getText() {
        if (locator != null) {
            Waiter.waitElement(locator);
            webElement = driver.findElement(locator);
        }
        return webElement.getText();
    }
}
