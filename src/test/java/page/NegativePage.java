package page;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class NegativePage {
    public NegativePage pathNegativeTest(String value){
        step("Поиск слова \"Тестирование\" в навигации", () -> {
            $(".breadcrumbs").shouldHave(text(value));
        });
        return this;
    }
    public NegativePage faviconNegativeTest(String value){
        step("Проверка на отсутствие фавикона", () -> {
            $(".wrap a").shouldBe(hidden);
        });
        return this;
    }


}
