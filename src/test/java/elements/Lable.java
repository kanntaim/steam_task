package elements;

import org.openqa.selenium.By;

public class Lable extends BaseElement{
    public Lable(By locator) {
        super(locator);
    }

    public Lable(String xpath) {
        this(By.xpath(xpath));
    }
}
