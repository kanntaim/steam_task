package forms;

import elements.Button;
import elements.ComboBox;
import elements.Menu;
import framework.utils.LanguageProperties;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Locale;


public class BaseSteamForm {

    private Button btnInstallSteam = setBtnInstallSteam();
    private ComboBox cmbLanguage = setCmbLanguage();

    public BaseSteamForm() {

    }

    private Button setBtnInstallSteam() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getButtonInstall();
        String buttonXpath = String.format("//a[contains(text(),\"%s\")]", buttonText);
        return new Button(buttonXpath);
    }

    private ComboBox setCmbLanguage() {
        String comboboxId = "language_pulldown";
        String itemsXpath = "//div[@id = \"language_dropdown\"]/descendant::a";
        return new ComboBox(By.id(comboboxId), By.xpath(itemsXpath));
    }

    public void navigateInstallSteam() {
        btnInstallSteam.click(10000, 600);
    }

    public void clickCmbLanguage() {
        cmbLanguage.click(10000, 600);
    }

//TODO isPageOpen, baseElementList, forms list
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
    }


}
