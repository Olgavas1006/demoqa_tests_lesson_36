package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class RegistrationWithJenkinsTest extends TestBaseWithJenkins {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("form")
    void successfulRegistrationTest() {
        step("Open form", () -> {
        registrationPage.openPage()
                .removeBanner();
        });

        step("Fill personal data", () -> {
                registrationPage.setFirstName("Olga")
                .setLastName("Vasileva")
                .setEmail("olgatest@v.com")
                .setGender("Female")
                .setUserNumber("8900111445")
                .setDateOfBirth( "6","November", "1987" )
                .setSubjects("Biology")
                .setHobbies("Sports")
                .setUploadPicture("cat.jpg")
                .setCurrentAddress("Уфа, Vladivostokskaya 23")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();
        });

        step("Verify results", () -> {
        registrationPage.checkResult("Student Name", "Olga Vasileva")
                .checkResult("Student Email", "olgatest@v.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8900111445")
                .checkResult("Date of Birth", "06 November,1987")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "cat.jpg")
                .checkResult("Address", "Уфа, Vladivostokskaya 23")
                .checkResult("State and City", "NCR Delhi");
        });
    }


    @Test
    @Tag("form")
    void minimalDataTest() {
        step("Open form", () -> {
        registrationPage.openPage()
                .removeBanner();
        });
        step("Fill personal data", () -> {
                registrationPage.setFirstName("Olga")
                .setLastName("Vasileva")
                .setGender("Female")
                .setUserNumber("8900111445")
                .setDateOfBirth( "6","November", "1987" )
                .submitForm();
        });

        step("Verify results", () -> {
        registrationPage.checkResult("Student Name", "Olga Vasileva")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8900111445")
                .checkResult("Date of Birth", "06 November,1987");
        });
    }

    @Test
    @Tag("form")
    void negativeNameTest() {
        step("Open form", () -> {
        registrationPage.openPage()
                .removeBanner();
        });
        step("Fill personal data", () -> {
                registrationPage.setFirstName("")
                .setLastName("Vasileva")
                .setGender("Female")
                .setUserNumber("8900111445")
                .setDateOfBirth( "6","November", "1987" )
                .submitForm();
        });
    }
}
