package elements;

import elements.BaseElement;
import org.openqa.selenium.By;

public class ComboBox extends BaseElement {

    public ComboBox(By locator){
        super(locator);
    }

    public ComboBox(String xpath){
        this(By.xpath(xpath));
    }
}
