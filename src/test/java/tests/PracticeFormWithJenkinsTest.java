package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class PracticeFormWithJenkinsTest {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
    }

    @Test
    @Tag("demoqa")
    void practiceFormTest() {

        step("Open form", () -> {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        });

        step("Fill form", () -> {
        $("#firstName").setValue("Olga");
        $("#lastName").setValue("Vasileva");
        $("#userEmail").setValue("olgatest@v.com");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("89001114455");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("November");
        $$(".react-datepicker__day").findBy(text("6")).click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("Ufa, Vladivostokskaya 23");
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();
        });

        step("Verify results", () -> {
        $(".table-responsive").shouldHave(text("Olga Vasileva"));
        $(".table-responsive").shouldHave(text("olgatest@v.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8900111445"));
        $(".table-responsive").shouldHave(text("6 November,1987"));
        $(".table-responsive").shouldHave(text("Biology"));
        $(".table-responsive").shouldHave(text("Sports, Reading"));
        $(".table-responsive").shouldHave(text("cat.jpg"));
        $(".table-responsive").shouldHave(text("Ufa, Vladivostokskaya 23"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
        });
    }

}
