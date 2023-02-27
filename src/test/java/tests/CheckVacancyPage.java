package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.linkText;

public class CheckVacancyPage extends TestBase {
    @Test
    @DisplayName("Проверка баннера на странице вакансии")
    void checkBannerTest(){
        $(".wrap").shouldBe(visible);
    }
    @Test
    @DisplayName("Проверка содержания заголовка вакансии")
    void checkHeadingTest(){
        String expectedTitle = "Инженер по автоматизации тестирования Java";
        $(".wrap h1").shouldHave(text(expectedTitle));
    }

    @CsvSource({
            "Компания, Компания Dunice вошла в состав группы компаний IBS",
            "Направления, IBS и МЭСИ заключили соглашение о стратегическом партнерстве",
            "Проекты, Управление проектами – для специалистов заказчика"
    })
    @ParameterizedTest(name = "Проверка наличия на сайте статьи {1} " + ", в результате ввода запроса {0}")
    void checkSearchTest(String searchWord, String categoryWord) {
        $(".header-search a").click();
        $("[type=text]").setValue(searchWord).pressEnter();
        $(".search-blocks").shouldHave(text(categoryWord));
    }

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
    @DisplayName("Заполнение личных данных на вакансию")
        void checkRegistrationPage() {
        $(linkText("Принять условия")).click();
        $(linkText("Откликнуться на вакансию")).click();
        $(".radio:nth-child(3) span:nth-child(2)").click();
        $("#link").setValue("https://hh.ru/resume/bedbb11cff092cc6850039ed1f6e5067464672");
        $("#name").setValue("Alexey");
        $("#last_name").setValue("Fadeev");
        $("#email").setValue("fadeevae87@gmail.com");
        $("#phone").setValue("+79264931943");
        $("#message").setValue("Здравствуйте. Направляю вам свое резюме...");
        $(".checkbox label span").click();
    }

    @Test
    @DisplayName("Поиск названия вакансии")
        void checkSearchVacancy(){
        $(".header-burger").click();
        $(".navigation-sections").$(byText("Карьера")).hover();
        $(".navigation-lists").$(byText("Вакансии")).click();
        $(".jobs-items").shouldHave(text("Аналитик СЭД"));
    }

    static Stream<Arguments> searchCategoryTest() {
        return Stream.of(
                Arguments.of("О компании", List.of("О компании", "Менеджмент",
                        "История IBS", "Признание", "Партнёры", "Раскрытие информации", "Контакты")),
                Arguments.of("Медиацентр", List.of("Проекты", "Новости", "Публикации в СМИ",
                        "События", "Материалы для СМИ")),
                Arguments.of("Решения и услуги", List.of("Управление программами",
                        "Бизнес-консалтинг", "Бизнес-решения", "Разработка", "Тестирование", "Аутсорсинг IT-процессов",
                        "Инфраструктура", "Информационная безопасность", "ESG и устойчивое развитие"))
        );
    }
    @MethodSource
    @ParameterizedTest(name = "Отображение списка подкатегорий {1} " + ", в категории {0}")
    void searchCategoryTest(String category, List<String> filter){
        $(".header-burger").click();
        $(".navigation-sections").$(byText(category)).hover();
        $$(".navigation-lists a").filter(visible).shouldHave(CollectionCondition.texts(filter));
    }
}



