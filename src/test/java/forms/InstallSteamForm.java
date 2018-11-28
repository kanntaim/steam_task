package forms;

import elements.Button;
import framework.drivers.WebDriver;
import framework.utils.LanguageProperties;
import framework.utils.Waiter;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.NoSuchElementException;

public class InstallSteamForm extends BaseSteamForm {

    private Button btnInstallSteam;
    private final String installSteamTemplate = "//span[contains(text(),\"%s\")]/ancestor::a";

    private void setInstallSteam() {
        LanguageProperties languageProperties = LanguageProperties.getInstance();
        String buttonText = languageProperties.getButtonInstall();
        String buttonXpath = String.format(installSteamTemplate, buttonText);
        btnInstallSteam = new Button(buttonXpath);
    }

    public void clickBtnInstallSteam() {
        setInstallSteam();
        btnInstallSteam.click(10000,600);
    }

    private void waitForFileDownloaded(URL url) {

    }

    public void downloadSteam() {
        clickBtnInstallSteam();
        URL url = null;
        try {
            url = new URL(btnInstallSteam.getHref());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Waiter.waitFileToDownload(url);
        System.out.println("nope");
    }
}
