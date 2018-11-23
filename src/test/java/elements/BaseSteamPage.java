package elements;

import forms.Button;
import forms.ComboBox;
import framework.utils.Properties;
import org.openqa.selenium.By;


public class BaseSteamPage {

    private Button btnInstallSteam = setBtnInstallSteam();
    private ComboBox cmbLanguage;

    public BaseSteamPage(){

    }

    private Button setBtnInstallSteam(){
        String buttonText = null;
        Properties properties = Properties.getInstance();
        String language = properties.getLanguage();
        switch (language){
            case "EN":
                buttonText = "Install Steam";
                break;
            case "RU":
                buttonText = "Установить Steam";
                break;
        }
        String buttonXpath = String.format("//a[contains(text(),\"%s\")]",buttonText);
        return new Button(buttonXpath);
    }

    private ComboBox setCmbLanguage(){

    }
}
