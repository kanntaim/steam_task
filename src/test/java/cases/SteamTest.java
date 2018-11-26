package cases;

import forms.BaseSteamForm;
import framework.utils.LanguageProperties;
import framework.utils.Properties;
import org.testng.annotations.Test;

import java.util.Locale;

public class SteamTest extends BaseTest {

    @Test
    @Override
    public void test() {
        Properties properties = Properties.getInstance();
        Locale language = properties.getLanguage();
        BaseSteamForm form = new BaseSteamForm();
        form.clickBtnInstallSteam();
        form.setLocale(new Locale("EN"));
    }
}
