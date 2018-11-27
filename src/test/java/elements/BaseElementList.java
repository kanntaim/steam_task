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
    private WebDriver driver;
    private By locator;

    public BaseElementList(By locator) {
        this.locator = locator;
        driver = WebDriver.getInstance();
    }

    public List<WebElement> getElements(long timeout, long pollingRate) {
        Waiter.waitElement(locator, timeout, pollingRate);
        List<WebElement> elementList = driver.findElements(locator);
        return elementList;
    }

    public List<String> getTextList(long timeout, long pollingRate) {
        Waiter.waitElement(locator, timeout, pollingRate);
        List<WebElement> elementList = driver.findElements(locator);
        List<String> textList = new LinkedList<>();
        for (WebElement element : elementList) {
            textList.add(element.getText());
        }
        return textList;
    }

    public void mouseOverAndClickElement(By locator, long timeout, long pollingRate){
        Waiter.waitElement(locator,timeout, pollingRate);
        WebElement webElement = driver.findElement(locator);
        Actions actions = new Actions(driver.getDriver());
        actions.moveToElement(webElement).click().perform();
    }

    public void mouseOver(By mouseOverLocator, long timeout, long pollingRate) {
        Waiter.waitElement(mouseOverLocator, timeout, pollingRate);
        WebElement mouseOverElement = driver.findElement(mouseOverLocator);
        Actions actions = new Actions(driver.getDriver());
        actions.moveToElement(mouseOverElement).perform();
    }

    public void jsClick(By locator,  long timeout, long pollingRate){
        Waiter.waitElement(locator,timeout, pollingRate);
        WebElement clickElement = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor)driver.getDriver();
        executor.executeScript("arguments[0].click();", clickElement);
    }
}
