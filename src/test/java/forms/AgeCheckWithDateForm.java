package forms;

import elements.Button;
import elements.ComboBox;
import org.openqa.selenium.By;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

class AgeCheckWithDateForm extends AgeCheckForm{

    private ComboBox cmbDay = new ComboBox(By.id("ageDay"),By.xpath("//select[@id=\"ageDay\"]/option"));
    private ComboBox cmbMonth = new ComboBox(By.id("ageMonth"),By.xpath("//select[@id=\"ageMonth\"]/option"));
    private ComboBox cmbYear = new ComboBox(By.id("ageYear"),By.xpath("//select[@id=\"ageYear\"]/option"));

    void setDate(Calendar date){
        cmbDay.click(10000, 600);
        List<Button> daysList = cmbDay.getItems();
        int i = 0;
        while (Integer.parseInt(daysList.get(i).getText(10000, 600)) != (date.get(Calendar.DAY_OF_MONTH))) {
            i++;
            if (i == daysList.size()) {
                return;
            }
        }
        daysList.get(i).click(10000, 600);
        cmbMonth.click(10000, 600);

        List<Button> monthsList = cmbMonth.getItems();
        i = 0;
        while (!monthsList.get(i).getText(10000, 600).equals(date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH))) {
            i++;
            if (i == monthsList.size()) {
                return;
            }
        }
        monthsList.get(i).click(10000, 600);

        cmbYear.click(10000, 600);
        List<Button> yearsList = cmbYear.getItems();
        i = 0;
        while (Integer.parseInt(yearsList.get(i).getText(10000, 600)) != (date.get(Calendar.YEAR))) {
            i++;
            if (i == yearsList.size()) {
                return;
            }
        }
        System.out.println(yearsList.get(i).getText(10000, 600));
        yearsList.get(i).click(10000, 600);
    }
}
