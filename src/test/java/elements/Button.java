package elements;

import org.openqa.selenium.By;

public class Button extends BaseElement {

    public Button(By locator) {

        super(locator);
    }

    public Button(String xpath) {
        this(By.xpath(xpath));
    }

    public void clickAndWait(BaseElement waitFor, long timeout, long pollingRate) {
        super.clickAndWait(waitFor, timeout, pollingRate);
    }

}
