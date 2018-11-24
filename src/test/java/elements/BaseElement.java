package elements;

import framework.drivers.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class BaseElement {
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

    public void clickAndWait(WebElement ) {
        WebDriver driver = WebDriver.getInstance();

        webElement.click();
    }

    public By getLocator(){
        return locator;
    }

    public RemoteWebElement getElement()

    public boolean isEnabled()

    public String getName()

    public void waitForIsElementPresent()

    public void sendKeys(Keys key)

    public void clickViaAction()

    public void clickExt()

    public void doubleClick()
}
