package ru.netology.selenide;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AppCardDeliveryTest {

    @Test
    void shouldTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Самара");
        String planningDate = generateDate(4);
        $("[data-test-id='date'] .input__control").doubleClick();
        $("[data-test-id='date'] .input__control").sendKeys(Keys.DELETE);
        $("[data-test-id='date'] .input__control").setValue(planningDate);
        $("[data-test-id='name'] .input__control").setValue("Артур Пирожков");
        $("[data-test-id='phone'] .input__control").setValue("+79877654321");
        $("[data-test-id='agreement'] .checkbox__text").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно назначена на " + planningDate));
    }

    private String generateDate(int addedDays) {
        return LocalDate.now().plusDays(addedDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
