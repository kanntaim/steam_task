package elements;

import framework.drivers.WebDriver;
import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.LinkedList;
import java.util.List;

public class BaseElementList {
    private final WebDriver driver;
    private final By locator;

    BaseElementList(By locator) {
        this.locator = locator;
        driver = WebDriver.getInstance();
    }

    public List<String> getTextList(long timeout, long pollingRate) {
        Waiter.waitElement(locator, timeout, pollingRate);
        return returnTextList();
    }

    public List<String> getTextList() {
        Waiter.waitElement(locator);
        return returnTextList();

    }

    private List<String> returnTextList() {
        List<WebElement> elementList = driver.findElements(locator);
        List<String> textList = new LinkedList<>();
        for (WebElement element : elementList) {
            textList.add(element.getText());
        }
        return textList;
    }

    public void mouseOver(By mouseOverLocator, long timeout, long pollingRate) {
        Waiter.waitElement(mouseOverLocator, timeout, pollingRate);
        doMouseOver(mouseOverLocator);
    }

    public void mouseOver(By mouseOverLocator) {
        Waiter.waitElement(mouseOverLocator);
        doMouseOver(mouseOverLocator);
    }

    private void doMouseOver(By mouseOverLocator) {
        WebElement mouseOverElement = driver.findElement(mouseOverLocator);
        Actions actions = new Actions(driver.getDriver());
        actions.moveToElement(mouseOverElement).perform();
    }

    public void jsClick(By locator, long timeout, long pollingRate) {
        Waiter.waitElement(locator, timeout, pollingRate);
        doJsClick(locator);
    }

    public void jsClick(By locator) {
        Waiter.waitElement(locator);
        doJsClick(locator);
    }

    private void doJsClick(By locator) {
        WebElement clickElement = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver.getDriver();
        executor.executeScript("arguments[0].click();", clickElement);
    }
}
