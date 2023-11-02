package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkTest {

    @BeforeAll
    static void beforeFillForm(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl= "https://demoqa.com/";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void fillForm(){
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Bohdan");
        $("#lastName").setValue("Peliutkevich");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userEmail").setValue("bohdan@gmail.com");
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--015").click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#subjectsInput").setValue("Hindi").pressEnter().setValue("English").pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/resources/image1.png"));
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#currentAddress").setValue("Alabama");
        $("#submit").click();
//        Assertions
        $(".modal-content").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $("tbody").$(byText("Student Name")).sibling(0).shouldHave(text("Bohdan Peliutkevich"));
        $("tbody").$(byText("Student Email")).sibling(0).shouldHave(text("bohdan@gmail.com"));
    }
}
