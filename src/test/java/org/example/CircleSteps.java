package org.example;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.*;

public class CircleSteps {

    double radius;
    double result;
    Exception exception;

    @Допустим("радиус равен {double}")
    @Step("Установить радиус {0}")
    public void setRadius(double r) {
        radius = r;
    }

    @Когда("я вычисляю площадь")
    @Step("Вычислить площадь круга")
    public void calc() {
        try {
            result = Circle.calculateArea(radius);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Тогда("результат положительный")
    @Step("Проверить, что площадь положительная")
    public void checkPositive() {
        assertTrue(result > 0);
    }

    @Тогда("возникает ошибка")
    @Step("Проверить, что возникла ошибка")
    public void checkError() {
        assertNotNull(exception);
    }
}