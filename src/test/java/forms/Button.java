package forms;

import elements.BaseElement;
import org.openqa.selenium.By;

public class Button extends BaseElement {

    public Button(By locator){
        super(locator);
    }

    public Button(String xpath){
        this(By.xpath(xpath));
    }

}
