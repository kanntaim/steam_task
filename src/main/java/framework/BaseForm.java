package framework;

import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseForm {
    protected boolean isFormOpen(By locator) {
        List<WebElement> list = Waiter.waitElements(locator);
        return list.size() != 0;
    }
}
