package framework.elements;

import org.openqa.selenium.By;

public class Menu extends BaseElementList {
    private final String submenuItemTemplate;

    public Menu(By locator, String submenuItemTemplate) {
        super(locator);
        this.submenuItemTemplate = submenuItemTemplate;
    }

    public String getSubmenuItemTemplate() {
        return submenuItemTemplate;
    }
}
