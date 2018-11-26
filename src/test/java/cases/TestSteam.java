package cases;

import forms.BaseSteamForm;
import framework.utils.Properties;

public class TestSteam extends BaseTest {
    private Properties properties = Properties.getInstance();
    private String url = properties.getUrl();

    @Override
    public void test() {
        BaseSteamForm form = new BaseSteamForm();
        form.clickBtnInstallSteam();
    }
}
