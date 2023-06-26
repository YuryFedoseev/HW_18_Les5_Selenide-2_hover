package guru.qa;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.*;

public class TestDragAndDrops {

    private int xOffset = 150;
    private int yOffset = 2;


    @BeforeAll
    static void beforeAll() {
        browserSize = "1220x880";
        holdBrowserOpen = true;
    }

    @Test
    public void dragAndDrops() {
        //Работает
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    public void dragAndDropsWithAction() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement element = $("#column-a");
        actions().dragAndDropBy(element, xOffset, yOffset).perform();
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        actions().contextClick(elementA).moveToElement(elementB);
        actions().dragAndDrop(elementA, elementB);
        $("#column-b").shouldHave(text("A"));

    }
}
