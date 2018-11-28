package forms;

import elements.Button;
import framework.utils.LanguageProperties;

public class InstallSteamForm extends BaseSteamForm {

    private Button btnInstallSteam;
    private final String installSteamTemplate = "//span[contains(text(),\"%s\")]/ancestor::a";

    private void setInstallSteam() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getButtonInstall();
        String buttonXpath = String.format(installSteamTemplate, buttonText);
        btnInstallSteam = new Button(buttonXpath);
    }

    private void clickBtnInstallSteam() {
        setInstallSteam();
        btnInstallSteam.click(10000, 600);
    }


    public String downloadSteam() {
        clickBtnInstallSteam();
        return btnInstallSteam.getHref();
    }

}
