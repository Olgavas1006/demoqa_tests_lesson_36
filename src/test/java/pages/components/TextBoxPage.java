package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("https://demoqa.com/text-box");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userName.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.click();
        return this;
    }

    public void checkResults(String name, String email, String currentAddr, String permanentAddr) {
        outputName.shouldHave(text(name));
        outputEmail.shouldHave(text(email));
        outputCurrentAddress.shouldHave(text(currentAddr));
        outputPermanentAddress.shouldHave(text(permanentAddr));
    }
}
