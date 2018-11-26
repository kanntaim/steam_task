package forms;

import elements.ComboBox;
import elements.Menu;
import org.openqa.selenium.By;

public class MainSteamForm extends BaseSteamForm {
        private Menu menuStoreNav = setMenuStoreNav();

        private Menu setMenuStoreNav(){
            String menuClass = "store_nav";
            String submenuClass = "pulldown_desktop";
            String submenuItemClass = "popup_menu_item";
            String[] argsFormat= {menuClass,submenuClass};
            String submenuXpath = String.format("//div[@class = \"%s\"]/descendant::a[@class=\"%s\"]", (Object[]) argsFormat);

            return new Menu(By.className(menuClass), By.xpath(submenuXpath),);
        }
}
