package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .setUserName("Anna")
                .setUserEmail("ash@mail.ru")
                .setCurrentAddress("Minsk, Masherova 1/2/3")
                .setPermanentAddress("Unknown")
                .clickSubmit();

        textBoxPage.checkResult("#name", "Anna")
                .checkResult("#email", "ash@mail.ru")
                .checkResult("#currentAddress", "Minsk, Masherova 1/2/3")
                .checkResult("#permanentAddress", "Unknown");
    }
}