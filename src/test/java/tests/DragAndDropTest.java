package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl= "https://the-internet.herokuapp.com/";
        Configuration.holdBrowserOpen = false;
    }
    @Test
    void dragAndDropAction() {
        open("drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        actions().moveToElement(elementA).clickAndHold().moveToElement(elementB).release().perform();
        elementA.shouldHave(text("B"));
    }

    @Test
    void dragAndDrop(){
        open("drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        elementA.dragAndDrop(DragAndDropOptions.to(elementB));
        elementA.shouldHave(text("B"));
        elementB.shouldHave(text("A"));

    }
}
