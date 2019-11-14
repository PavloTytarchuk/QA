package tytarchuk;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ChromeSettings {
    protected void setUpBrowser() {
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.startMaximized = true;
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        WebDriverManager.chromedriver().avoidPreferences();
    }

    protected void closeWebDriver() {
        WebDriverRunner.closeWebDriver();
    }
}

