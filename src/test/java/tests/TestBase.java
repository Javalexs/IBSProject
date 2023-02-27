package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import page.GeneralPage;
import page.LocatorPage;
import page.RegPage;

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

}
