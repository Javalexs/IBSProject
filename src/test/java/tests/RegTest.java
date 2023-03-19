package tests;

import config.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegTest extends TestBase {
    @Test
    @DisplayName("Проверка страницы отклика на вакансию")
    void checkRegistrationPageTest() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        String name = config.getName();
        String lastName = config.getLastName();
        String link = config.getLink();
        String email = config.getEmail();
        String phone = config.getPhone();
        String phrase = config.getPhrase();

        regPage.firstAct()
                .setLinkCv(link)
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setPhone(phone)
                .setMessage(phrase)
                .checkBox();
    }
}
