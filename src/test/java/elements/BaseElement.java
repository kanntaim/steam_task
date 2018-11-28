package elements;

import framework.drivers.WebDriver;
import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    private WebElement webElement;
    private WebDriver driver;
    private By locator;

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

    public String getText(long timeout, long pollingRate) {
        if (locator != null) {
            Waiter.waitElement(locator, timeout, pollingRate);
            webElement = driver.findElement(locator);
        }
        return webElement.getText();
    }


    public String getHref() {
        return webElement.getAttribute("href");
    }

}
