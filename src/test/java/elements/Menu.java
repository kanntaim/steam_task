package elements;

import org.openqa.selenium.By;

public class Menu extends BaseElementList {


    private By menuItemLocator;
    private String submenuItemTemplate;

    public Menu(String xpath, By menuItemLocator, String submenuItemTemplate) {//todo remove if unneeded
        this(By.xpath(xpath),menuItemLocator,submenuItemTemplate);
    }

    public Menu(By locator, By menuItemLocator, String submenuItemTemplate) {
        super(locator);
        this.menuItemLocator = menuItemLocator;
        this.submenuItemTemplate = submenuItemTemplate;
    }

    public void clickSubmenuItem(By locator, long timeout, long pollingRate) {//todo enum

    }

    public String getSubmenuItemTemplate() {
        return submenuItemTemplate;
    }
}
