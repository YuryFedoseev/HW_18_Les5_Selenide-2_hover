package guru.qa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.*;

public class TestSearchWithHover {
    @BeforeAll
    static void beforeAll() {
        browserSize = "1220x880";
        holdBrowserOpen = false;
    }


    @Test
    public void searchElementsOnGit() {
        open("https://github.com/");
        $$(".HeaderMenu-link").findBy(text("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();

        $("div.enterprise-hero").shouldHave(text("Build like the best"));

    }

}
