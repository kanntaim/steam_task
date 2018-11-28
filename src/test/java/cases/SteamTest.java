package cases;

import forms.*;
import framework.utils.DateParser;
import framework.utils.Properties;
import framework.utils.Waiter;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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
        String downloadLink = installSteamForm.downloadSteam();
        assertTrue(isFileCreated(downloadLink));
    }

    private boolean isFileCreated(String href) {

        Properties properties = Properties.getInstance();
        String browser = properties.getBrowserName();
        String path = properties.getBrowserDownloadDirectory();
        if (browser.equals("Chrome")) {
            File downloadedFile = new File(path + "/" + "SteamSetup.exe");
            while (!downloadedFile.exists()) {
                try {
                    Thread.sleep(600);//todo remove thread sleep or not
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        URL url = null;
        try {
            url = new URL(href);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        Waiter.waitFileToDownload(url);//todo create directory
        return true;
    }
}
