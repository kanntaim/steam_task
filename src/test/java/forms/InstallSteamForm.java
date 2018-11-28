package forms;

import elements.Button;
import framework.utils.LanguageProperties;
import framework.utils.Properties;
import framework.utils.Waiter;

import java.net.MalformedURLException;
import java.net.URL;

public class InstallSteamForm extends BaseSteamForm {

    private Button btnInstallSteam;
    private final String installSteamTemplate = "//span[contains(text(),\"%s\")]/ancestor::a";

    private void setInstallSteam() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getButtonInstall();
        String buttonXpath = String.format(installSteamTemplate, buttonText);
        btnInstallSteam = new Button(buttonXpath);
    }

    public void clickBtnInstallSteam() {
        setInstallSteam();
        btnInstallSteam.click(10000, 600);
    }

    private void waitForFileDownloaded(URL url) {

    }

    public String downloadSteam() {
        clickBtnInstallSteam();
        return btnInstallSteam.getHref();
    }

    private void navigateDownload() {
        navigate("chrome://downloads/");
    }
}
