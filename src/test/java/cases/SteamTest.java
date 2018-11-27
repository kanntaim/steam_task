package cases;

import forms.ActionsSteamForm;
import forms.BaseSteamForm;
import forms.MainSteamForm;
import framework.utils.Properties;
import org.testng.annotations.Test;

import java.util.Locale;

public class SteamTest extends BaseTest {

    @Test
    @Override
    public void test() {
        Properties properties = Properties.getInstance();
        Locale language = properties.getLanguage();
        MainSteamForm form = new MainSteamForm();
        //form.navigateInstallSteam();
        //form.setLocale(new Locale("RU"));
        form.navigateSubmenu(MainSteamForm.MenuItems.GAMES, MainSteamForm.SubmenuItems.ACTIONS);
        ActionsSteamForm actionsForm = new ActionsSteamForm();
        actionsForm.clickBtnSpecials();
        actionsForm.navigateMaxDiscountGame();
        System.out.println("stop it");
    }
}
