package page;

import com.codeborne.selenide.CollectionCondition;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LocatorPage {


    public LocatorPage categoryTest(String value, List<String> arr){
        $(".header-burger").click();
        $(".navigation-sections").$(byText(value)).hover();
        $$(".navigation-lists a").filter(visible).shouldHave(CollectionCondition.texts(arr));
        return this;
    }
    public LocatorPage searchTest(String value, String word){
        $(".header-search a").click();
        $("[type=text]").setValue(value).pressEnter();
        $(".search-blocks").shouldHave(text(word));
        return this;
    }

    public LocatorPage subTitleTest(String value){
        $$(".col-9 col-t-12").find(text(value));
        return this;
    }
}
