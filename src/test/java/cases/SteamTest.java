package cases;

import forms.InstallSteamForm;
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
        form.setLocale(new Locale("RU"));
        form.navigateInstallSteam();
        InstallSteamForm installSteamForm = new InstallSteamForm();
        installSteamForm.downloadSteam();
//        form.navigateSubmenu(MainSteamForm.MenuItems.GAMES, MainSteamForm.SubmenuItems.ACTIONS);
//        ActionsSteamForm actionsForm = new ActionsSteamForm();
//        actionsForm.clickBtnSpecials();
//        MainSteamForm undefinedForm = actionsForm.navigateMaxDiscountGame();
//        List<String> parameters = actionsForm.getChosenGameParameters();
//        if (undefinedForm instanceof AgeCheckForm) {
//            Calendar date = Calendar.getInstance();
//            date.set(1986, Calendar.DECEMBER, 19);
//            ((AgeCheckForm) undefinedForm).passAgeCheckForm(date);
//        }
//        GameForm gameForm = new GameForm();
//        assertTrue(gameForm.isPricesEqual(parameters));//todo remove assert
//


        System.out.println("stop it");//todo check correct discount values
    }
}
