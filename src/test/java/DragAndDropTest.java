import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    void DragAndDropCheck() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-b").$("header").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-b").$("header").shouldHave(text("A"));
    }

    @Test
    void DragAndDropWithAction() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-b").$("header").shouldHave(text("B"));
        $("#column-a").hover();
        actions().clickAndHold().moveByOffset(250, 0).release().perform();
        $("#column-b").$("header").shouldHave(text("A"));

    }
}
