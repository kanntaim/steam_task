package forms;

import elements.Button;
import elements.ComboBox;
import framework.utils.LanguageProperties;


public class BaseSteamForm {

    private Button btnInstallSteam = setBtnInstallSteam();
    private ComboBox cmbLanguage;

    public BaseSteamForm() {

    }

    private Button setBtnInstallSteam() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getButtonInstall();
        String buttonXpath = String.format("//a[contains(text(),\"%s\")]", buttonText);
        return new Button(buttonXpath);
    }

    private ComboBox setCmbLanguage() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String comboboxText = languageProperties.getComboboxLanguage();
        String comboboxXpath = String.format("//span[contains(text(),\"%s\")]", comboboxText);
        return new ComboBox(comboboxXpath);
    }

    public void clickBtnInstallSteam() {
        InstallSteamForm installSteamForm = new InstallSteamForm();
        btnInstallSteam.clickAndWait(installSteamForm.getBtnInstallSteam(), 10000, 600);
    }
}
