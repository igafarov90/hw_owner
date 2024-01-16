import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("igafarov")
public class HabrTests extends TestBase {


    @Test
    @DisplayName("Проверка табов главного меню")
    void checkMainMenuTabsTest() {
        step("Перейти к главной странице сайта habr.com", () -> {
         open(baseUrl);
        });
        step("Проверка ожидаемого результата", () -> {
            String expectResult = "Моя лента\nВсе потоки\nРазработка\n" +
                    "Администрирование\nДизайн\nМенеджмент\nМаркетинг\nНаучпоп";
            $(".tm-main-menu__section-content").shouldHave(Condition.text(expectResult));
        });
    }

    @Test
    void searchPublicationTest(){
        step("Перейти к главной странице сайта habr.com", () -> {
        open(baseUrl);
        });
        step("Выполнить поиск статьи allure", () -> {
        $(".tm-header-user-menu__search").click();
        $("input.tm-input-text-decorated__input").setValue("Allure").pressEnter();
        });
            step("Проверить наличие статьи allure", () -> {
        $(".tm-articles-list").shouldHave(Condition.text("Allure-framework. Часть 1"));
        });
    }

}
