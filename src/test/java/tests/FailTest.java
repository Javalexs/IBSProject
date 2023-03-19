package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FailTest extends TestBase {
    @ValueSource(strings = {
            "Главная",
            "Карьера",
            "Вакансии"
    })
    @ParameterizedTest(name = "Поиск элемента \"{0}\" в навигации страницы")
    void checkPathFailTest(String str) {
        failPage.pathFailTest(str);
    }//для того чтобы тест упал ввести слово "Тестирование"

    @Test
    @DisplayName("Проверка отсутствия фавикона")
    void checkFaviconFailTest(){
        failPage.faviconFailTest();
    }
}
