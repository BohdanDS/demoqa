package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LocatorsExampleTest {
    @Test
    void cssXpath(){
        $("[data-testid=email]").setValue("test@gmail.com");
        $(by("data-testid", "email")).setValue("test@gmail.com");
        $x("//*[data-testid='email']").setValue("test@gmail.com");
        $(byId("email")).setValue("");
        $("#email").setValue("");
        $(byText("Hello World")).click();
        $(withText("Hello ")).click();
        $x("//*[text()='Hello World']").click(); // not usable
        $x("//*[contains[text(),'Hello ']]").click(); // preferable
        $x("//*[contains[@class(),'input_class_form']]").click(); // preferable
    }
}
