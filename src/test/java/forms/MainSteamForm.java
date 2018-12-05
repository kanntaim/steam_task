package forms;

import form_enums.MenuItems;
import form_enums.SubmenuItems;
import framework.elements.Menu;
import org.openqa.selenium.By;

public class MainSteamForm extends BaseSteamForm {
    private final By menuLocator = By.className("store_nav");
    private final String submenuItemTemplate = "//a[contains(text(),\"%s\")]";
    private Menu menuStoreNav;

    public MainSteamForm() {
        isFormOpen(menuLocator);
        setMenuStoreNav();
    }

    private void setMenuStoreNav() {
        menuStoreNav = new Menu(menuLocator, submenuItemTemplate);
    }

    public void navigateSubmenu(MenuItems item, SubmenuItems submenuItem) {
        String menuItemId = item.getId();
        String submenuItemText = submenuItem.getText();
        By menuItemLocator = By.id(menuItemId);
        By submenuItemLocator = By.xpath(String.format(menuStoreNav.getSubmenuItemTemplate(), submenuItemText));

        menuStoreNav.mouseOver(menuItemLocator);
        menuStoreNav.jsClick(submenuItemLocator);
    }
}
