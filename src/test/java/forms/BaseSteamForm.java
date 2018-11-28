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

    private Button btnInstallSteam;
    private ComboBox cmbLanguage = setCmbLanguage();

    public BaseSteamForm() {

    }

    private void setBtnInstallSteam() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getButtonInstall();
        String buttonXpath = String.format("//a[contains(text(),\"%s\")]", buttonText);
        btnInstallSteam = new Button(buttonXpath);
    }

    private ComboBox setCmbLanguage() {
        return new ComboBox(cmbLanguageLocator, cmbLanguageItemsLocator);
    }

    public void navigateInstallSteam() {
        setBtnInstallSteam();
        btnInstallSteam.click(10000, 600);
    }

    public void setLocale(Locale locale) {
        String localeLanguage = locale.getLanguage();
        String language;
        switch (localeLanguage) {
            case "ru":
                language = "Русский";
                break;
            case "en":
                language = "English";
                break;
            default:
                System.out.println("Wrong locale language");
                return;
        }
        cmbLanguage.click(10000, 600);
        List<Button> buttonList = cmbLanguage.getItems();
        int i = 0;
        while (!buttonList.get(i).getText(10000, 600).startsWith(language)) {
            i++;
            if (i == buttonList.size()) {
                cmbLanguage.click(10000, 600);
                return;
            }
        }
        buttonList.get(i).click(10000, 600);
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        languageProperties.setConfig(locale);
    }


}
