package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebElement;

public class BaseElement {
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
