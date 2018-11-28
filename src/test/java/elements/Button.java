package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    public Button(By locator) {

        super(locator);
    }

    public Button(String xpath) {
        this(By.xpath(xpath));
    }

    Button(WebElement element){
        super(element);
    }
}
