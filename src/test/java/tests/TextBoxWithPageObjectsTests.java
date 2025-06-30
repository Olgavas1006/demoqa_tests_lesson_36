package tests;

import org.junit.jupiter.api.Test;
import pages.components.TextBoxPage;

public class TextBoxWithPageObjectsTests {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void formBoxTests() {
        TextBoxPage textBoxPage = new TextBoxPage();

        textBoxPage.openPage()
                .setUserName("Olga")
                .setUserEmail("olgatest@v.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submitForm()
                .checkResults("Olga", "olgatest@v.com", "Some street 1", "Another street 1");
    }
}
