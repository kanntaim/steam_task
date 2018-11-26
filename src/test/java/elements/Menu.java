package elements;

import framework.drivers.WebDriver;
import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Menu extends BaseElement {
    private By submenuLocator;
    private By submenuItemLocator;

    public Menu(By locator, By submenuLocator, By submenuItemLocator) {
        super(locator);
        this.submenuLocator = submenuLocator;
        this.submenuItemLocator = submenuItemLocator;


    }

    public Menu(String xpath, String submenuXpath, String submenuItemXpath) {
        this(By.xpath(xpath), By.xpath(submenuXpath), By.xpath(submenuItemXpath));
    }

    public List<ComboBox> getItems() {//todo enum
        Waiter.wait(submenuLocator, 10000, 600);
        WebDriver driver = WebDriver.getInstance();
        List<WebElement> items = driver.findElements(submenuLocator);
        List<ComboBox> cmbItems = new ArrayList<>(items.size());
        for (WebElement item : items) {
            cmbItems.add(new ComboBox(submenuLocator, submenuItemLocator));
        }
        return cmbItems;
    }
}
