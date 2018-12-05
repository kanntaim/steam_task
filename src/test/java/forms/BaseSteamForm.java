package forms;

import elements.Button;
import elements.ComboBox;
import framework.utils.LanguageProperties;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Locale;


public class BaseSteamForm extends BaseForm {
    private final By cmbLanguageLocator = By.id("language_pulldown");
    private final By cmbLanguageItemsLocator = By.xpath("//div[@id = \"language_dropdown\"]/descendant::a");
    private final String installButtonTemplate = "//a[contains(text(),\"%s\")]";

    private Button btnInstallSteam;
    private ComboBox cmbLanguage;

    private void setBtnInstallSteam() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonInstallSteamText = languageProperties.getButtonInstall();
        String buttonInstallSteamXpath = String.format(installButtonTemplate, buttonInstallSteamText);//todo ask if name is bad one
        btnInstallSteam = new Button(buttonInstallSteamXpath);
    }

    private void setCmbLanguage() {
        cmbLanguage = new ComboBox(cmbLanguageLocator, cmbLanguageItemsLocator);
    }

    public void navigateInstallSteam() {
        setBtnInstallSteam();
        btnInstallSteam.click();
    }

    public void setLocale(Locale locale) {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        languageProperties.setConfig(locale);
        String language = languageProperties.getLanguageComboboxItem();
        setCmbLanguage();
        cmbLanguage.click();
        List<Button> buttonList = cmbLanguage.getItems();
        int i = 0;
        while (!buttonList.get(i).getText().startsWith(language)) {
            if (++i == buttonList.size()) {
                cmbLanguage.click();
                return;
            }
        }
        buttonList.get(i).click();
    }
}
