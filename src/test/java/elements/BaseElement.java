package elements;

import framework.drivers.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class BaseElement {
    private WebElement webElement;

    public BaseElement(By locator){
        WebDriver driver = WebDriver.getInstance();
        webElement = driver.findElement(locator);
    }

    public BaseElement(String xpath){
        this(By.xpath(xpath));
    }

    public RemoteWebElement getElement()
    public boolean isEnabled()
    public By getLocator()
    public String getName()
    public void waitForIsElementPresent()
    public void sendKeys(Keys key)
    public void clickViaAction()
    public void clickExt()
    public void doubleClick()
}
