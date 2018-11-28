package forms;

import elements.Button;
import elements.ComboBox;
import org.openqa.selenium.By;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

class AgeCheckWithDateForm extends AgeCheckForm{

    ComboBox day = new ComboBox(By.id("ageDay"),By.xpath("//select[@id=\"ageDay\"]/option"));
    ComboBox month = new ComboBox(By.id("ageMonth"),By.xpath("//select[@id=\"ageMonth\"]/option"));
    ComboBox year = new ComboBox(By.id("ageYear"),By.xpath("//select[@id=\"ageYear\"]/option"));

    void setDate(Calendar date){
        day.click(10000, 600);
        List<Button> daysList = day.getItems();
        int i = 0;
        while (Integer.parseInt(daysList.get(i).getText(10000, 600)) != (date.get(Calendar.DAY_OF_MONTH))) {
            i++;
            if (i == daysList.size()) {
                return;
            }
        }
        daysList.get(i).click(10000, 600);
        month.click(10000, 600);

        List<Button> monthsList = month.getItems();
        i = 0;
        while (!monthsList.get(i).getText(10000, 600).equals(date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH))) {
            i++;
            if (i == monthsList.size()) {
                return;
            }
        }
        monthsList.get(i).click(10000, 600);

        year.click(10000, 600);
        List<Button> yearsList = year.getItems();
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
