package forms;

import elements.Button;
import framework.utils.LanguageProperties;

public class InstallSteamForm extends BaseSteamForm {

    private Button btnInstallSteam;

    private void setInstallSteam() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getButtonInstall();
        String buttonXpath = String.format("//span[contains(text(),\"%s\")]/ancestor::a", buttonText);
        btnInstallSteam = new Button(buttonXpath);
    }

    public void clickBtnInstallSteam() {
        setInstallSteam();
        btnInstallSteam.click(10000,600);
    }

    public void downloadSteam() {
        clickBtnInstallSteam();
        System.out.println("nope");
    }
}
