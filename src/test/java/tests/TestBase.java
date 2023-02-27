package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeEach
    void addSite(){
        open("https://ibs.ru/career/jobs/inzhener-po-avtomatizatsii-testirovaniya-java-lyuboy-region-rf-udalennaya-rabota/");
        Configuration.holdBrowserOpen = true;
    }

}
