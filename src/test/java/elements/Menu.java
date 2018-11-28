package elements;

import org.openqa.selenium.By;

public class Menu extends BaseElementList {
    private String submenuItemTemplate;

    public Menu(By locator, String submenuItemTemplate) {
        super(locator);
        this.submenuItemTemplate = submenuItemTemplate;
    }

    public String getSubmenuItemTemplate() {
        return submenuItemTemplate;
    }
}
