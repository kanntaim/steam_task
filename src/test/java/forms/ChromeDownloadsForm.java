package forms;

import elements.Button;
import org.openqa.selenium.By;

public class ChromeDownloadsForm extends BaseForm {
    private final By keepLocator = By.xpath("//paper-button[contains(text(),\"Keep\")]");

    public void acceptDownload(){
        Button keep = new Button(keepLocator);
        keep.click(10000,600);
    }
}
