package page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class GeneralPage {

    public GeneralPage bannerTest(){
        step("Проверка заголовка вакансии", () -> {
            $(".wrap").shouldBe(visible);
        });
        return this;
    }
    public GeneralPage headingTest(String value){
        step("Проверка соответствия содержания заголовка вакансии", () -> {
            $(".wrap h1").shouldHave(text(value));
        });
        return this;
    }
    public GeneralPage searchVacancyTest(String value){;
        step("Открываем меню в правом верхнем углу", () -> {
            $(".header-burger").click();
        });
        step("Наводим курсор на раздел \"Карьера\"", () -> {
            $(".navigation-sections").$(byText("Карьера")).hover();
        });
        step("Переходим в подраздел \"Вакансии\" ", () -> {
            $(".navigation-lists").$(byText("Вакансии")).click();
        });
        step("Проверяем есть ли нужная вакансия на странице", () -> {
            $(".jobs-items").shouldHave(text(value));
        });
        return this;
    }
}
