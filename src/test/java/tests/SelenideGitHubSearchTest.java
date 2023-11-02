package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGitHubSearchTest {
    @BeforeAll
    static void beforeAlltest(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl= "https://github.com/";

        Configuration.holdBrowserOpen = false;
    }
    @Test
    void searchSelenideOnGithub (){
//        Bad locators to practice collection
        open("selenide/selenide");
        $("#wiki-tab").click();
        $$("[data-filterable-for='wiki-pages-filter'] li").last().$("button").click();
        $("[data-filterable-for='wiki-pages-filter']").shouldHave(text("SoftAssertions"));
        $("[data-filterable-for='wiki-pages-filter']").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
    @Test
    void searchJUnitCodeOnGithub(){
        open("selenide/selenide");
        $("#wiki-tab").click();
        $$("#wiki-pages-box li" ).last().$("button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
