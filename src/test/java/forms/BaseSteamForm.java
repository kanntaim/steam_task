package forms;

import elements.Button;
import elements.ComboBox;
import framework.utils.LanguageProperties;


public class BaseSteamForm {

    private Button btnInstallSteam = setBtnInstallSteam();
    private ComboBox cmbLanguage;

    public BaseSteamForm(){

    }

    private Button setBtnInstallSteam(){
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getButtonInstall();
        String buttonXpath = String.format("//a[contains(text(),\"%s\")]",buttonText);
        return new Button(buttonXpath);
    }

    private ComboBox setCmbLanguage(){
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getButtonInstall();

    }

}
