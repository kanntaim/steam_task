package forms;

import elements.Button;
import elements.Label;
import elements.LabelsList;
import framework.utils.LanguageProperties;
import org.openqa.selenium.By;

import java.util.List;

public class ActionsSteamForm extends MainSteamForm {
    private Button btnSpecials;
    private LabelsList discounts;
    private String chosenGameDiscount;
    private String chosenGamePrice;

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

    public MainSteamForm navigateMaxDiscountGame() {
        setDiscounts();
        String maxDiscount = getMaxDiscount();
        By maxDiscountGameLocator = By.xpath(String.format("//span[contains(text(),\"%s\")]/ancestor::a", maxDiscount));

        Button maxDiscountGame = new Button(maxDiscountGameLocator);
        String priceLocatorString = String.format("//span[contains(text(),\"%s\")]/ancestor::a//descendant::strike/../..", maxDiscount);
        setChosenGameParameters(maxDiscount, priceLocatorString);
        maxDiscountGame.click(10000, 600);

        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getViewPage();
        By buttonLocator = By.xpath(String.format("//span[contains(text(),\"%s\")]", buttonText));
        if (isFormOpen(buttonLocator, 10000, 600)) {
            return new AgeCheckForm();
        } else{
            return new GameForm();
        }
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

    private void setChosenGameParameters(String chosenGameDiscount, String chosenGamePriceLocatorString) {
        this.chosenGameDiscount = chosenGameDiscount;
        Label priceLabel = new Label(By.xpath(chosenGamePriceLocatorString));
        this.chosenGamePrice = priceLabel.getText(10000, 600);
    }


}
