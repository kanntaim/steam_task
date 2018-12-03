package forms;

import elements.Button;
import elements.ComboBox;
import org.openqa.selenium.By;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

class AgeCheckWithDateForm extends AgeCheckForm {

    private final ComboBox cmbDay = new ComboBox(By.id("ageDay"), By.xpath("//select[@id=\"ageDay\"]/option"));
    private final ComboBox cmbMonth = new ComboBox(By.id("ageMonth"), By.xpath("//select[@id=\"ageMonth\"]/option"));
    private final ComboBox cmbYear = new ComboBox(By.id("ageYear"), By.xpath("//select[@id=\"ageYear\"]/option"));

    void setDate(Calendar date) {
        cmbDay.click();
        List<Button> daysList = cmbDay.getItems();
        int i = 0;
        while (Integer.parseInt(daysList.get(i).getText()) != (date.get(Calendar.DAY_OF_MONTH))) {
            i++;
            if (i == daysList.size()) {
                return;
            }
        }
        daysList.get(i).click();
        cmbMonth.click();

        List<Button> monthsList = cmbMonth.getItems();
        i = 0;
        while (!monthsList.get(i).getText().equals(date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH))) {
            i++;
            if (i == monthsList.size()) {
                return;
            }
        }
        monthsList.get(i).click();

        cmbYear.click();
        List<Button> yearsList = cmbYear.getItems();
        i = 0;
        while (Integer.parseInt(yearsList.get(i).getText()) != (date.get(Calendar.YEAR))) {
            i++;
            if (i == yearsList.size()) {
                return;
            }
        }
        yearsList.get(i).click();
    }
}
