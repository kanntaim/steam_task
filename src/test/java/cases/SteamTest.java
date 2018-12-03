package cases;

import forms.*;
import forms.form_enums.MenuItems;
import forms.form_enums.SubmenuItems;
import framework.utils.DateParser;
import framework.utils.Properties;
import framework.utils.Waiter;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SteamTest extends BaseTest {

    @Override
    public void test() {
        Properties properties = Properties.getInstance();
        Locale language = properties.getLanguage();
        MainSteamForm form = new MainSteamForm();
        System.out.println(form);
        form.setLocale(language);

        form.navigateSubmenu(MenuItems.GAMES, SubmenuItems.ACTIONS);
        ActionsSteamForm actionsForm = new ActionsSteamForm();
        actionsForm.clickBtnSpecials();
        MainSteamForm undefinedForm = actionsForm.navigateMaxDiscountGame();
        List<String> parameters = actionsForm.getChosenGameParameters();
        if (undefinedForm instanceof AgeCheckForm) {
            Calendar date = Calendar.getInstance();
            DateParser.parse(properties.getAgeCheckBirthDate());
            ((AgeCheckForm) undefinedForm).passAgeCheckForm(date);
        }
        GameForm gameForm = new GameForm();
        assertTrue(gameForm.isPricesEqual(parameters));

        form.navigateInstallSteam();
        InstallSteamForm installSteamForm = new InstallSteamForm();
        installSteamForm.downloadSteam();
        assertTrue(isFileCreated());
    }

    private boolean isFileCreated() {
        try {
            Properties properties = Properties.getInstance();
            String path = properties.getBrowserDownloadDirectory();
            String fileName = properties.getDownloadedFileName();
            File downloadedFile = new File(path + File.pathSeparator + fileName);
            Waiter.waitForFileDownloaded(downloadedFile);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
