package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

//
public class CheckIBSVacancy extends TestBase {
    @BeforeEach
    void openUrl(){
        open("/career/jobs/inzhener-po-avtomatizatsii-testirovaniya-java-lyuboy-region-rf-udalennaya-rabota/");
    }
    @Test
    @Tag("start")
    @Tag("stop")
    @DisplayName("Проверка наличия заголовка вакансии")
    void checkBannerTest(){
        generalPage.bannerTest();
    }
    @Test
    @Tag("start")
    @DisplayName("Проверка содержания заголовка вакансии")
    void checkHeadingTest(){
        String expectedTitle = "Инженер по автоматизации тестирования Java";
        generalPage.headingTest(expectedTitle);

    }
    @Test
    @Tag("start")
    @DisplayName("Проверка  вакансии на странице")
    void checkSearchVacancyTest(){
        String value = "Аналитик СЭД";
        generalPage.searchVacancyTest(value);
    }

    @ValueSource(strings = {
            "Ваши задачи",
            "Наши ожидания",
            "Мы предлагаем"
    })
    @ParameterizedTest(name = "Поиск подзаголовка {0} в тексте вакансии")
    @Tag("start")
    void searchSubTitleTest(String value) {
        locatorPage.subTitleTest(value);
    }

    @CsvSource({
            "Компания, Компания Dunice вошла в состав группы компаний IBS",
            "Направления, IBS и МЭСИ заключили соглашение о стратегическом партнерстве",
            "Проекты, Управление проектами – для специалистов заказчика"
    })
    @ParameterizedTest(name = "Проверка названия статьи {1} " + ", в результате ввода запроса в поиск {0}")
    @Tag("start")
    void checkSearchTest(String searchWord, String categoryWord) {
        step("Присутствие заголовка статьи в результате ввода запроса", () ->{
            locatorPage.searchTest(searchWord, categoryWord);
        });
    }
    static Stream<Arguments> searchCategoryTest() {
        List <String> company = List.of("О компании", "Менеджмент",
                "История IBS", "Признание", "Партнёры", "Раскрытие информации", "Контакты");
        List <String> center = List.of("Проекты", "Новости", "Публикации в СМИ",
                "События", "Материалы для СМИ");
        List <String> service =  List.of("Управление программами",
                "Бизнес-консалтинг", "Бизнес-решения", "Разработка", "Тестирование", "Аутсорсинг IT-процессов",
                "Инфраструктура", "Информационная безопасность", "ESG и устойчивое развитие");

        return Stream.of(
                Arguments.of("О компании", company),
                Arguments.of("Медиацентр", center),
                Arguments.of("Решения и услуги", service)
        );
    }
    @MethodSource
    @ParameterizedTest(name = "Проверка отображения списка подкатегорий {1} " + ", в категории {0}")
    @Tag("start")
    void searchCategoryTest(String category, List<String> filter){
            locatorPage.categoryTest(category, filter);
    }
    @Test
    @Tag("start")
    @DisplayName("Проверка страницы отклика на вакансию")
    void checkRegistrationPageTest() {
        String link = "https://hh.ru/resume/bedbb11cff092cc6850039ed1f6e5067464672";
        String name = "Alexey";
        String last_name = "Fadeev";
        String email = "fadeevae87@gmail.com";
        String phone = "+79260123456";
        String str = "Доброго времени суток. Направляю вам свое резюме...";

        regPage.firstAct()
               .setLinkCv(link)
               .setFirstName(name)
               .setLastName(last_name)
               .setEmail(email)
               .setPhone(phone)
               .setMessage(str)
               .checkBox();

    }
    @ValueSource(strings = {
        "Главная",
        "Карьера",
        "Вакансии",
        "Тестирование"
    })
    @ParameterizedTest(name = "Поиск элемента {0} в навигации страницы")
    @Tag("start")
    void checkPathFailTest(String str) {
        failPage.pathFailTest(str);
    }
    @Test
    @Tag("start")
    @DisplayName("Проверка отсутствия фавикона")
    void checkFaviconFailTest(){
        failPage.faviconFailTest();
    }
}



