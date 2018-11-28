package forms;

import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

class BaseForm {
    boolean isFormOpen(By locator) {
        List<WebElement> list = Waiter.waitElements(locator);
        return list.size() != 0;
    }
}
