package cases;

import forms.ActionsSteamForm;
import forms.AgeCheckForm;
import forms.MainSteamForm;
import framework.utils.Properties;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Locale;

public class SteamTest extends BaseTest {

    @Test
    @Override
    public void test() {
        Properties properties = Properties.getInstance();
        Locale language = properties.getLanguage();
        MainSteamForm form = new MainSteamForm();
        //form.navigateInstallSteam();
        form.setLocale(new Locale("RU"));
        form.navigateSubmenu(MainSteamForm.MenuItems.GAMES, MainSteamForm.SubmenuItems.ACTIONS);
        ActionsSteamForm actionsForm = new ActionsSteamForm();
        actionsForm.clickBtnSpecials();
        MainSteamForm undefinedForm = actionsForm.navigateMaxDiscountGame();
        if (undefinedForm instanceof AgeCheckForm) {
            Calendar date = Calendar.getInstance();
            date.set(1986, Calendar.DECEMBER, 19);
            ((AgeCheckForm) undefinedForm).passAgeCheckForm(date);
        }


        System.out.println("stop it");//todo check correct discount values
    }
}
