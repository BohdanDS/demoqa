package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Bohdan");
        $("#userEmail").setValue("bohdan@gmail.com");
        $("#currentAddress").setValue("currentAddress_Address");
        $("#permanentAddress").setValue("permanentAddress_Address");
        $("#submit").click();

        $("#output #name").shouldHave(text("Bohdan"));
        $("#output #email").shouldHave(text("bohdan@gmail.com"));
        $("#output #currentAddress").shouldHave(text("currentAddress_Address"));
        $("#output #permanentAddress").shouldHave(text("permanentAddress_Address"));
    }
}
