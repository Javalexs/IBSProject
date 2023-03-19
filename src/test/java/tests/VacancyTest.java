package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VacancyTest extends TestBase {
    @Test
    @DisplayName("Проверка на наличие заголовка вакансии")
    void checkBannerTest(){
        generalPage.bannerTest();
    }

    @Test
    @DisplayName("Проверка содержания заголовка вакансии")
    void checkHeadingTest(){
        String expectedTitle = "Инженер по автоматизации тестирования Java";
        generalPage.headingTest(expectedTitle);
    }

    @Test
    @DisplayName("Проверка названия вакансии на странице")
    void checkSearchVacancyTest(){
        String value = "Архитектор информационных систем";
        generalPage.searchVacancyTest(value);
    }
}
