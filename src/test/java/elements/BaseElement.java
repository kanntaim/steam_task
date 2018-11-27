package elements;

import framework.drivers.WebDriver;
import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseElement {
    private WebElement webElement;
    private WebDriver driver;
    private By locator;

    public BaseElement(By locator) {
        this.locator = locator;
        driver = WebDriver.getInstance();
        webElement = null;
    }
    public BaseElement(WebElement element) {
        locator = null;
        driver = WebDriver.getInstance();
        webElement = element;
    }

    public BaseElement(String xpath) {
        this(By.xpath(xpath));
    }

    public void click(long timeout, long pollingRate) {
        if (locator !=null){
            Waiter.waitElement(locator, timeout, pollingRate);
            webElement = driver.findElement(locator);
        }
        webElement.click();
    }

    public void jsClick(long timeout, long pollingRate){
        if (locator !=null){
            Waiter.waitElement(locator, timeout, pollingRate);
            webElement = driver.findElement(locator);
        }
        JavascriptExecutor executor = (JavascriptExecutor)driver.getDriver();
        executor.executeScript("arguments[0].click();", webElement);
    }

    public void moveAndClick(long timeout, long pollingRate){
        if (locator !=null){
            Waiter.waitElement(locator, timeout, pollingRate);
            webElement = driver.findElement(locator);
        }
        Actions actions = new Actions(driver.getDriver());
        actions.moveToElement(webElement).click().perform();
    }

    public String getText(long timeout, long pollingRate){
        if (locator !=null){
            Waiter.waitElement(locator, timeout, pollingRate);
            webElement = driver.findElement(locator);
        }
        return webElement.getText();
    }

    public By getLocator() {
        return locator;
    }

//    public RemoteWebElement getElement()
//
//    public boolean isEnabled()
//
//    public String getName()
//
//    public void waitForIsElementPresent()
//
//    public void sendKeys(Keys key)
//
//    public void clickViaAction()
//
//    public void clickExt()
//
//    public void doubleClick()
}
