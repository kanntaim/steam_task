package forms;

import elements.Button;
import framework.utils.LanguageProperties;

public class ActionsSteamForm {
    private Button btnSpecials = setBtnSpecials();

    private Button setBtnSpecials() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getSeeAllSpecials();
        String buttonXpath = String.format("//span[contains(text(),\"%s\")]//ancestor::a",buttonText);
        return new Button(buttonXpath);
    }

    public void clickBtnSpecials(){
        btnSpecials.click(10000,600);
    }
}
