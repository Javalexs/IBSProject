package page;

import com.codeborne.selenide.CollectionCondition;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class LocatorPage {
    public LocatorPage categoryTest(String value, List<String> arr){
        step("Открываем меню в правом верхнем углу", () -> {
            $(".header-burger").click();
        });
        step("Находим нужный раздел ", () -> {
            $(".navigation-sections").$(byText(value)).hover();
        });
        step("Проверяем наличие подразделов в разделе", () -> {
            $$(".navigation-lists a").filter(visible).shouldHave(CollectionCondition.texts(arr));
        });
        return this;
    }
    public LocatorPage searchTest(String value, String word){
        step("Открываем поиск", () -> {
            $(".header-search a").click();
        });
        step("Вводим слово в поисковую строку", () -> {
            $("[type=text]").setValue(value).pressEnter();
        });
        step("Поиск нужной статьи", () -> {
            $(".search-blocks").shouldHave(text(word));
        });
        return this;
    }

    public LocatorPage subTitleTest(String value){
        step("Поиск подзаголовков в тексте вакансии", () -> {
            $$(".col-9 col-t-12").find(text(value));
        });
        return this;
    }
}
