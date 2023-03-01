package page;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class FailPage {
    public FailPage pathFailTest(String value){
        step("Поиск слова \"Тестирование\" в навигации", () -> {
            $(".breadcrumbs").shouldHave(text(value));
        });
        return this;
    }
    public FailPage faviconFailTest(){
        step("Проверка на отсутствие фавикона", () -> {
            $(".wrap a").shouldBe(hidden);
        });
        return this;
    }


}
