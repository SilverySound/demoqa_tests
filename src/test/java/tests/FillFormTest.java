package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FillFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void TextBoxTests() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("Anna@Ivanova.com");

        $("#gender-radio-2").parent().click();

        $("#userNumber").setValue("3752911122");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("images/1.png");

        $("#currentAddress").setValue("Street 1");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));




    }
}

