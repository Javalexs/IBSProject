package page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class RegPage {
    private static final String url = "/career/jobs/inzhener-po-avtomatizatsii-testirovaniya-java-lyuboy-region-rf-udalennaya-rabota/";
    public RegPage firstAct(){
        open(url);
        step("Жмем кнопку \"Принять условия\"", () -> {
            $(linkText("Принять условия")).click();
        });
        step("Жмем кнопку \"Откликнуться на вакансию\"", () -> {
            $(linkText("Откликнуться на вакансию")).click();
        });
        step("Выбираем добавить резюме ссылкой", () -> {
            $(".radio:nth-child(3) span:nth-child(2)").click();
        });
        return this;
    }
    public RegPage setLinkCv(String value){

        step("Вставляем ссылку на вакансия с сайта hh.ru", () -> {
            $("#link").setValue(value);
        });
        return this;
    }
    public RegPage setFirstName(String value){

        step("Вводим имя", () -> {
            $("#name").setValue(value);
        });
        return this;
    }
    public RegPage setLastName(String value){
        step("Вводим фамилию", () -> {
            $("#last_name").setValue(value);
        });
        return this;
    }
    public RegPage setEmail(String value){
        step("Вводим адрес электронной почты", () -> {
            $("#email").setValue(value);
        });
        return this;
    }
    public RegPage setPhone(String value){
        step("Вводим контактный номер телефона", () -> {
            $("#phone").setValue(value);
        });
        return this;
    }
    public RegPage setMessage(String value){
        step("Вводим сопроводительное сообщение", () -> {
            $("#message").setValue(value);
        });
        return this;
    }
    public RegPage checkBox(){
        step("Ставим галочку в разделе \"Я согласен на обработку персональных данных\"", () -> {
            $(".checkbox label span").scrollIntoView(true).click();
        });
        return this;
    }


}
