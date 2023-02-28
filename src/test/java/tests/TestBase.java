package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import page.GeneralPage;
import page.LocatorPage;
import page.RegPage;
import helpers.Attach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    GeneralPage generalPage = new GeneralPage();
    RegPage regPage = new RegPage();
    LocatorPage locatorPage = new LocatorPage();
    @BeforeEach
    void addSite(){
        open("https://ibs.ru/career/jobs/inzhener-po-avtomatizatsii-testirovaniya-java-lyuboy-region-rf-udalennaya-rabota/");
//        Configuration.browserSize = "1920x1080";
        Configuration.browserSize = "1024x768";
        Configuration.holdBrowserOpen = true;
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
