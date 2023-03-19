package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegTest extends TestBase {
    @Test
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
}
