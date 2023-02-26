package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class CheckVacancyPage {
    @BeforeEach
    void cookieAndBase(){
        open("https://ibs.ru/career/jobs/inzhener-po-avtomatizatsii-testirovaniya-java-lyuboy-region-rf-udalennaya-rabota/");
//        $(linkText("Принять условия")).click();
    }

    @Test
    @DisplayName("Проверка баннера на странице вакансии")
    void checkBannerTest(){
        open("https://ibs.ru/career/jobs/inzhener-po-avtomatizatsii-testirovaniya-java-lyuboy-region-rf-udalennaya-rabota/");
        $(".wrap").shouldBe(visible);
    }
//    @Test
//    @DisplayName("Проверка заголовка вакансии")
//    void checkHeadingTest(){
//        open("https://ibs.ru/career/jobs/inzhener-po-avtomatizatsii-testirovaniya-java-lyuboy-region-rf-udalennaya-rabota/");
//        String expectedTitle = "Инженер по автоматизации тестирования Java";
//        String actualTitle = title();
//        assertThat(actualTitle).isEqualTo(expectedTitle);
//    }
    @ValueSource(strings = {
                "Ваши задачи",
                "Наши ожидания",
                "Мы предлагаем"
    })
    @ParameterizedTest(name = "Поиск подзаголовка {0} в тексте вакансии")
        void searchSubTitle(String value) {
            $$(".col-9 col-t-12").find(text(value));
    }
    @Test
    @DisplayName("Проверка баннера на странице вакансии")
    void checkRegistrationPage() {
        $(linkText("Принять условия")).click();
        Configuration.holdBrowserOpen = true;
        $(linkText("Откликнуться на вакансию")).click();
        $(".checkbox").$(".active").click();

    }
}



