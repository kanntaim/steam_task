package cases;

import forms.ActionsSteamForm;
import forms.AgeCheckForm;
import forms.GameForm;
import forms.MainSteamForm;
import framework.utils.Properties;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static org.testng.Assert.assertTrue;

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
        List<String> parameters = actionsForm.getChosenGameParameters();
        if (undefinedForm instanceof AgeCheckForm) {
            Calendar date = Calendar.getInstance();
            date.set(1986, Calendar.DECEMBER, 19);
            ((AgeCheckForm) undefinedForm).passAgeCheckForm(date);
        }
        GameForm gameForm = new GameForm();
        assertTrue(gameForm.isPricesEqual(parameters));//todo remove assert


        System.out.println("stop it");//todo check correct discount values
    }
}
