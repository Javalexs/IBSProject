package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckVacancyPage {
    @Test
    @DisplayName("Проверка баннера на странице вакансии")
    void checkBannerTest(){
        open("https://ibs.ru/career/jobs/inzhener-po-avtomatizatsii-testirovaniya-java-lyuboy-region-rf-udalennaya-rabota/");
        $(".wrap").shouldBe(visible);
    }
    @Test
    @DisplayName("Проверка заголовка вакансии")
    void checkHeadingTest(){
        open("https://ibs.ru/career/jobs/inzhener-po-avtomatizatsii-testirovaniya-java-lyuboy-region-rf-udalennaya-rabota/");
        String expectedTitle = "Инженер по автоматизации тестирования Java";
        String actualTitle = title();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}
