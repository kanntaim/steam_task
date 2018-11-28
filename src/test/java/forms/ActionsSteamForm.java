package forms;

import elements.Button;
import elements.Label;
import elements.LabelsList;
import framework.utils.LanguageProperties;
import org.openqa.selenium.By;

import java.util.LinkedList;
import java.util.List;

public class ActionsSteamForm extends MainSteamForm {
    private final By discountsLocator = By.xpath("//span[contains(text(),\"%\")]");
    private final String btnSpecialsTemplate = "//span[contains(text(),\"%s\")]//ancestor::a";
    private final String maxDiscountGameTemplate = "//span[contains(text(),\"%s\")]/ancestor::a";
    private final String priceTemplate = "//span[contains(text(),\"%s\")]/ancestor::a//descendant::strike/../..";
    private final String itemTemplate = "//span[contains(text(),\"%s\")]";

    private Button btnSpecials;
    private LabelsList discounts;
    private String chosenGameDiscount;
    private String chosenGamePrice;

    private void setBtnSpecials() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getSeeAllSpecials();
        String buttonXpath = String.format(btnSpecialsTemplate, buttonText);
        btnSpecials = new Button(buttonXpath);
    }

    private void setDiscounts() {
        discounts = new LabelsList(discountsLocator);
    }

    public void clickBtnSpecials() {
        setBtnSpecials();
        btnSpecials.click(10000, 600);
    }

    public MainSteamForm navigateMaxDiscountGame() {
        setDiscounts();
        String maxDiscount = getMaxDiscount();
        By maxDiscountGameLocator = By.xpath(String.format(maxDiscountGameTemplate, maxDiscount));

        Button maxDiscountGame = new Button(maxDiscountGameLocator);
        String priceLocatorString = String.format(priceTemplate, maxDiscount);
        setChosenGameParameters(maxDiscount, priceLocatorString);
        maxDiscountGame.click(10000, 600);

        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getViewPage();
        By buttonLocator = By.xpath(String.format(itemTemplate, buttonText));
        if (isFormOpen(buttonLocator, 10000, 600)) {
            return new AgeCheckForm();
        } else {
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

    public List<String> getChosenGameParameters() {
        List<String> parameters = new LinkedList<>();
        parameters.add(chosenGameDiscount);
        parameters.add(chosenGamePrice);
        return parameters;
    }


}
