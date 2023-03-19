package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

@Tag("start")
public class SubtitleTest extends TestBase {
    @ValueSource(strings = {
            "Ваши задачи",
            "Наши ожидания",
            "Мы предлагаем"
    })
    @ParameterizedTest(name = "Поиск подзаголовка \"{0}\" в тексте вакансии")
    void searchSubTitleTest(String value) {
        locatorPage.subTitleTest(value);
    }

    @CsvSource({
            "Компания, Компания Dunice вошла в состав группы компаний IBS",
            "Направления, IBS и МЭСИ заключили соглашение о стратегическом партнерстве",
            "Проекты, Управление проектами – для специалистов заказчика"
    })
    @ParameterizedTest(name = "Проверка присутствия названия статьи \"{1}\"" + ", в результате ввода запроса в поиск \"{0}\"")
    void checkSearchTest(String searchWord, String categoryWord) {
                    locatorPage.searchTest(searchWord, categoryWord);
    }

    static Stream<Arguments> searchCategoryTest() {
        List <String> company = List.of("О компании", "Менеджмент",
                "История IBS", "Признание", "Партнёры", "Раскрытие информации", "Контакты");
        List <String> center = List.of("Новости", "Публикации в СМИ",
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
    @ParameterizedTest(name = "Проверка отображения списка подкатегорий \"{1}\"" + ", в категории \"{0}\"")
    void searchCategoryTest(String category, List<String> filter){
        locatorPage.categoryTest(category, filter);
    }


}



