package forms;

import elements.Button;
import framework.utils.LanguageProperties;

public class InstallSteamForm extends BaseSteamForm {

    private Button btnInstallSteam = setInstallSteam();

    private Button setInstallSteam() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getButtonInstall();
        String buttonXpath = String.format("//span[contains(text(),\"%s\")]/ancestor::a", buttonText);
        return new Button(buttonXpath);
    }

    public Button getBtnInstallSteam() {
        return btnInstallSteam;
    }
}
