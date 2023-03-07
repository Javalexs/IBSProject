package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.FailPage;
import page.GeneralPage;
import page.LocatorPage;
import page.RegPage;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public GeneralPage generalPage = new GeneralPage();
    public RegPage regPage = new RegPage();
    public LocatorPage locatorPage = new LocatorPage();
    public FailPage failPage = new FailPage();
    @BeforeAll
    static void addSite(){
        ProjectConfig.setUp();
    }
    @BeforeEach
    void openUrl(){
        open("/career/jobs/inzhener-po-avtomatizatsii-testirovaniya-java-lyuboy-region-rf-udalennaya-rabota/");
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Скриншот экрана");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
