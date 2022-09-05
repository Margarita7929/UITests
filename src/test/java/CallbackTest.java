import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {



    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $("[data-test-id=callback-form]");
        form.$("[data-test-id=name] input").setValue("Быковская Маргарита");
        form.$("[data-test-id=phone] input").setValue("+79094657837");
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();


        $(".order-success").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }


}
