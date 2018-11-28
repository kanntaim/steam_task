package forms;


import elements.Button;
import framework.utils.LanguageProperties;
import org.openqa.selenium.By;

import java.util.Calendar;

public class AgeCheckForm extends MainSteamForm {
    private final By ageDayLocator= By.xpath("//select[@id=\"ageDay\"]/option");
    private final String viewPageTemplate = "//span[contains(text(),\"%s\")]";

    private Button btnViewPage; //todo make all Buttons etc. to btnName etc.

    AgeCheckForm(){

    }

    private void setBtnViewPage(){ //todo all setters called on need and return void
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getViewPage();
        By buttonLocator = By.xpath(String.format(viewPageTemplate, buttonText));
        btnViewPage = new Button(buttonLocator);
    }

    public void passAgeCheckForm(Calendar date){
        if (isFormOpen(ageDayLocator,10000, 600)){
            AgeCheckWithDateForm ageCheckWithDateForm = new AgeCheckWithDateForm();
            ageCheckWithDateForm.setDate(date);
        }
        setBtnViewPage();
        btnViewPage.click(10000,600);//todo (one more) unhardcode timeouts
    }




}
