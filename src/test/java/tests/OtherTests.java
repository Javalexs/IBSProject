package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Tag("start")
@Tag("stop")
public class OtherTests extends TestBase{
    @Test
    @DisplayName("Проверка наличия заголовка вакансии")
    void checkBannerTest(){
        generalPage.bannerTest();
    }
}
