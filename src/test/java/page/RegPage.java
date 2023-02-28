package page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class RegPage {
    public RegPage firstAct(){
        $(linkText("Принять условия")).click();
        $(linkText("Откликнуться на вакансию")).click();
        $(".radio:nth-child(3) span:nth-child(2)").click();
        return this;
    }
    public RegPage setLinkCv(String value){
        $("#link").setValue(value);
        return this;
    }
    public RegPage setFirstName(String value){
        $("#name").setValue(value);
        return this;
    }
    public RegPage setLastName(String value){
        $("#last_name").setValue(value);
        return this;
    }
    public RegPage setEmail(String value){
        $("#email").setValue(value);
        return this;
    }
    public RegPage setPhone(String value){
        $("#phone").setValue(value);
        return this;
    }
    public RegPage setMessage(String value){
        $("#message").setValue(value);
        return this;
    }
    public RegPage checkBox(){
        $(".checkbox label span").scrollIntoView(true).click();
        return this;
    }


}
