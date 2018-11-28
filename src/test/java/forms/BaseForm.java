package forms;

import framework.drivers.WebDriver;
import framework.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

class BaseForm {
    boolean isFormOpen(By locator, long timeout, long pollingRate) {
        List<WebElement> list = Waiter.waitElements(locator, timeout, pollingRate);
        return list.size()!=0;
    }
}
