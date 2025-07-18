package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");

        //убираем рекламу
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        // Заполнение формы
        $("#firstName").setValue("Olga");
        $("#lastName").setValue("Vasileva");
        $("#userEmail").setValue("olgatest@v.com");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("89001114455");

        // Выбор даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("November");
        $$(".react-datepicker__day").findBy(text("6")).click();

        // Ввод предмета
        $("#subjectsInput").setValue("Biology").pressEnter();

        // Выбор хобби
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();

        // Загрузка изображения
        $("#uploadPicture").uploadFromClasspath("котик.jpg");

        // Ввод адреса
        $("#currentAddress").setValue("Уфа, Владивостокская 23");

        // Выбор штата и города
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        // Подтверждение отправки формы
        $("#submit").click();

        // Проверка результатов в модальном окне
        $(".table-responsive").shouldHave(text("Olga Vasileva"));
        $(".table-responsive").shouldHave(text("olgatest@v.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8900111445"));
        $(".table-responsive").shouldHave(text("6 November,1987"));
        $(".table-responsive").shouldHave(text("Biology"));
        $(".table-responsive").shouldHave(text("Sports, Reading"));
        $(".table-responsive").shouldHave(text("котик.jpg"));
        $(".table-responsive").shouldHave(text("Уфа, Владивостокская 23"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }

    @Test
    void minimalDataTest() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        // Заполняем только обязательные поля
        $("#firstName").setValue("Olga");
        $("#lastName").setValue("Vasileva");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("8900111445");

        $("#submit").click();

        // Проверяем, что форма отправилась с минимальным набором данных
        $(".table-responsive").shouldHave(text("Olga Vasileva"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8900111445"));
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
    }

    @Test
    void negativeNumberTest() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        $("#firstName").setValue("");
        $("#lastName").setValue("Vasileva");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("8900111445");
        $("#submit").click();


    }

}
