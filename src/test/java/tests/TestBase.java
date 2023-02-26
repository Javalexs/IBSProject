package tests;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    void ibsOpen() {
        Configuration.browserSize = "1920x1080";
        open("https://www.dns-shop.ru/catalog/17a8bfb516404e77/tv-konsoli-i-audio/");
        Configuration.holdBrowserOpen = true;
    }

}
