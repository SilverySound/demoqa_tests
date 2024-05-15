
package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            SubmitButton = $("#submit"),
            OutputInfo = $("#output");

    ResultComponent resultComponent = new ResultComponent();
    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.click();
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.click();
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmit() {
        SubmitButton.click();
        return this;
    }


    public TextBoxPage checkResult(String key, String value) {
        OutputInfo.shouldBe(appear);
        OutputInfo.$(key).shouldHave(text(value));
        return this;
    }
}