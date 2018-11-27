package forms;

import elements.Button;
import elements.LabelsList;
import framework.utils.LanguageProperties;
import org.openqa.selenium.By;

import java.util.List;

public class ActionsSteamForm {
    private Button btnSpecials;
    private LabelsList discounts;

    private void setBtnSpecials() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getSeeAllSpecials();
        String buttonXpath = String.format("//span[contains(text(),\"%s\")]//ancestor::a", buttonText);
        btnSpecials = new Button(buttonXpath);
    }

    private void setDiscounts() {
        discounts = new LabelsList(By.xpath("//span[contains(text(),\"%\")]"));
    }

    public void clickBtnSpecials() {
        setBtnSpecials();
        btnSpecials.click(10000, 600);
    }

    public void navigateMaxDiscountGame(){
        setDiscounts();
        String maxDiscount = getMaxDiscount();
        By maxDiscountGameLocator = By.xpath(String.format("//span[contains(text(),\"%s\")]/ancestor::a",maxDiscount));
        Button maxDiscountGame = new Button(maxDiscountGameLocator);
        maxDiscountGame.click(10000,600);
    }

    private String getMaxDiscount() {
        List<String> discountsTextList = discounts.getTextList(10000, 600);//FIXME default t/o + polling rt
        Integer maxDiscount = 0;
        for (String discountText : discountsTextList) {
            Integer discount = Integer.parseInt(discountText.replace('%', ' ').trim());
            maxDiscount = Math.min(discount, maxDiscount);
        }
        return maxDiscount.toString();
    }

}
