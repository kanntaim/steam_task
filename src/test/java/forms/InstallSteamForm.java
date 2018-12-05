package forms;

import framework.elements.Button;
import framework.utils.LanguageProperties;

public class InstallSteamForm extends BaseSteamForm {
    private final String installSteamTemplate = "//span[contains(text(),\"%s\")]/ancestor::a";

    private Button btnInstallSteam;

    private void setInstallSteam() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getButtonInstall();
        String buttonXpath = String.format(installSteamTemplate, buttonText);
        btnInstallSteam = new Button(buttonXpath);
    }

    private void clickBtnInstallSteam() {
        setInstallSteam();
        btnInstallSteam.click();
    }


    public void downloadSteam() {
        clickBtnInstallSteam();
    }

}
