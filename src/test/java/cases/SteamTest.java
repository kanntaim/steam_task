package cases;

import forms.*;
import framework.utils.DateParser;
import framework.utils.Properties;
import framework.utils.Waiter;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SteamTest extends BaseTest {

    @Test
    @Override
    public void test() {
        Properties properties = Properties.getInstance();
        Locale language = properties.getLanguage();
        MainSteamForm form = new MainSteamForm();
        form.setLocale(language);

        form.navigateSubmenu(MainSteamForm.MenuItems.GAMES, MainSteamForm.SubmenuItems.ACTIONS);
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
        Properties properties = Properties.getInstance();
        String path = properties.getBrowserDownloadDirectory();
        File downloadedFile = new File(path + "/" + "SteamSetup.exe");
        Waiter.waitForFileDownloaded(downloadedFile);
        return true;
    }
}
