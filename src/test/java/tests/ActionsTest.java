package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ActionsTest {

    @BeforeAll
    static void beforeAllTest(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl= "https://github.com/";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void githubHover(){
        $(".HeaderMenu--logged-out").$(byText("Solutions")).hover();
        $(byAttribute("href","/enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform."));
    }
}
