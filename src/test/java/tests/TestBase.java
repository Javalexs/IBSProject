package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.GeneralPage;
import page.LocatorPage;
import page.NegativePage;
import page.RegPage;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public GeneralPage generalPage = new GeneralPage();
    public RegPage regPage = new RegPage();
    public LocatorPage locatorPage = new LocatorPage();
    public NegativePage negativePage = new NegativePage();
    @BeforeAll
    static void addSite(){
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://ibs.ru");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
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
