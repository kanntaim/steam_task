package elements;

import framework.drivers.WebDriver;
import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ComboBox extends BaseElement {
    private By itemsLocator;

    public ComboBox(By locator, By itemsLocator) {
        super(locator);
        this.itemsLocator = itemsLocator;

    }

    public ComboBox(String xpath, String itemsXpath) {
        this(By.xpath(xpath), By.xpath(itemsXpath));
    }

    public List<Button> getItems() {
        Waiter.wait(itemsLocator, 10000, 600);
        WebDriver driver = WebDriver.getInstance();
        List<WebElement> items = driver.findElements(itemsLocator);
        List<Button> btnItems = new ArrayList<>(items.size());
        for (WebElement item : items) {
            btnItems.add(new Button(item));
        }
        return btnItems;
    }
}
