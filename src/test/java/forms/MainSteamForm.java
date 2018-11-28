package forms;

import elements.Menu;
import framework.utils.LanguageProperties;
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

        menuStoreNav.mouseOver(menuItemLocator, 10000, 600);
        menuStoreNav.jsClick(submenuItemLocator, 10000, 600);
    }

    public enum MenuItems {
        YOUR_STORE("foryou_tab"),
        GAMES("genre_tab"),
        SOFTWARE("software_tab"),
        HARDWARE("hardware_tab"),
        VIDEOS("videos_tab");

        private final String id;

        MenuItems(String id) {
            this.id = id;
        }

        String getId() {
            return this.id;
        }
    }

    public enum SubmenuItems {
        ACTIONS("menuGamesActions");

        private final String text;

        SubmenuItems(String propertyKey) {
            LanguageProperties languageProperties = LanguageProperties.getInstance();
            this.text = languageProperties.getProperty(propertyKey);
        }

        String getText() {
            return this.text;
        }
    }
}
