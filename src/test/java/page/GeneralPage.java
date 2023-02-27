package page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GeneralPage {

    public GeneralPage bannerTest(){
        $(".wrap").shouldBe(visible);
        return this;
    }

    public GeneralPage headingTest(String value){
        $(".wrap h1").shouldHave(text(value));
        return this;
    }

    public GeneralPage searchVacancyTest(String value){
        $(".header-burger").click();
        $(".navigation-sections").$(byText("Карьера")).hover();
        $(".navigation-lists").$(byText("Вакансии")).click();
        $(".jobs-items").shouldHave(text(value));
        return this;
    }
}
