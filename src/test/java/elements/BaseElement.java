package elements;

import framework.drivers.WebDriver;
import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public abstract class BaseElement {
    private WebElement webElement;
    private WebDriver driver;
    private By locator;

    public BaseElement(By locator) {
        this.locator = locator;
        driver = WebDriver.getInstance();
        webElement = driver.findElement(locator);
    }

    public BaseElement(String xpath) {
        this(By.xpath(xpath));
    }

    public void clickAndWait(BaseElement waitFor, long timeout, long pollingRate) {
        WebDriver driver = WebDriver.getInstance();
        Waiter.wait(locator,timeout,pollingRate);
        webElement.click();
        By locator = waitFor.getLocator();
        Waiter.wait(locator,timeout,pollingRate);
    }

    public By getLocator(){
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
