package page;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class FailPage {
    public FailPage pathFailTest(String value){
        step("Поиск слова \"Вакансии\" в навигации", () -> { //для того чтобы тест упал ввести слово "Тестирование"
            $(".breadcrumbs").shouldHave(text(value));
        });
        return this;
    }
    public FailPage faviconFailTest(){
        step("Проверка на отсутствие фавикона", () -> {
            $(".wrap a").shouldBe(visible);//для того чтобы тест упал ввести "hidden"
        });
        return this;
    }


}
