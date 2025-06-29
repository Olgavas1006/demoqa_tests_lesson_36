package tests;

import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Olga")
                .setLastName("Vasileva")
                .setEmail("olgatest@v.com")
                .setGender("Female")
                .setUserNumber("8900111445")
                .setDateOfBirth( "6","November", "1987" )
                .setSubjects("Biology")
                .setHobbies("Sports")
                .setUploadPicture("котик.jpg")
                .setCurrentAddress("Уфа, Владивостокская 23")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();
        registrationPage.checkResult("Student Name", "Olga Vasileva")
                .checkResult("Student Email", "olgatest@v.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8900111445")
                .checkResult("Date of Birth", "06 November,1987")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "котик.jpg")
                .checkResult("Address", "Уфа, Владивостокская 23")
                .checkResult("State and City", "NCR Delhi");

    }

    @Test
    void minimalDataTest() {
        registrationPage.openPage()
                .setFirstName("Olga")
                .setLastName("Vasileva")
                .setGender("Female")
                .setUserNumber("8900111445")
                .setDateOfBirth( "6","November", "1987" )
                .submitForm();
        registrationPage.checkResult("Student Name", "Olga Vasileva")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8900111445")
                .checkResult("Date of Birth", "06 November,1987");

    }

    @Test
    void negativeNameTest() {
        registrationPage.openPage()
                .setFirstName("")
                .setLastName("Vasileva")
                .setGender("Female")
                .setUserNumber("8900111445")
                .setDateOfBirth( "6","November", "1987" )
                .submitForm();
        registrationPage.checkResultNegative("Student Name", "   Vasileva")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8900111445")
                .checkResult("Date of Birth", "06 November,1987");
    }
}
