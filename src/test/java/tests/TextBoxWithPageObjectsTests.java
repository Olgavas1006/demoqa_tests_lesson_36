package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxWithPageObjectsTests {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void formBoxTests() {
        TextBoxPage textBoxPage = new TextBoxPage();

        textBoxPage.openPage()
                .removeBanner()
                .setUserName("Olga")
                .setUserEmail("olgatest@v.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submitForm();
        textBoxPage.checkResults ("Name:", "Olga")
                .checkResults ("Email:", "olgatest@v.com")
                .checkResults ("Current Address :", "Some street 1")
                .checkResults ("Permananet Address :", "Another street 1");


    }
}
