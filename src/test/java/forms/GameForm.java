package forms;

import framework.elements.Label;
import org.openqa.selenium.By;

import java.util.List;

public class GameForm extends MainSteamForm {
    private final By discountPercentLocator = By.className("discount_pct");
    private final By discountPriceLocator = By.className("discount_prices");
    private Label lblDiscountPercent;
    private Label lblDiscountPrice;

    public boolean isPricesEqual(List<String> actionPageParameters) {
        setLblDiscountPrice();
        setLblDiscountPercent();
        return lblDiscountPercent.getText().replace('%', ' ').trim().equals(actionPageParameters.get(0))
                && lblDiscountPrice.getText().equals(actionPageParameters.get(1));
    }

    private void setLblDiscountPercent() {
        lblDiscountPercent = new Label(discountPercentLocator);
    }

    private void setLblDiscountPrice() {
        lblDiscountPrice = new Label(discountPriceLocator);
    }
}
