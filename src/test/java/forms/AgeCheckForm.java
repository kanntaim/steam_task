package forms;


import elements.Button;
import framework.utils.LanguageProperties;
import org.openqa.selenium.By;

import java.util.Calendar;

public class AgeCheckForm extends MainSteamForm {
    private final By ageDayLocator = By.xpath("//select[@id=\"ageDay\"]/option");
    private final String viewPageTemplate = "//span[contains(text(),\"%s\")]";

    private Button btnViewPage;

    AgeCheckForm() {

    }

    private void setBtnViewPage() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getViewPage();
        By buttonLocator = By.xpath(String.format(viewPageTemplate, buttonText));
        btnViewPage = new Button(buttonLocator);
    }

    public void passAgeCheckForm(Calendar date) {
        if (isFormOpen(ageDayLocator)) {
            AgeCheckWithDateForm ageCheckWithDateForm = new AgeCheckWithDateForm();
            ageCheckWithDateForm.setDate(date);
        }
        setBtnViewPage();
        btnViewPage.click();
    }


}
