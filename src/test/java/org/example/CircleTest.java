package org.example;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void testArea() {
        stepCalculateArea(1, Math.PI);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 1, 2, 5})
    void testDifferentRadius(double radius) {
        stepCalculateArea(radius, Circle.calculateArea(radius));
    }

    @Test
    void testNegativeRadius() {
        assertThrows(IllegalArgumentException.class,
                () -> Circle.calculateArea(-1));
    }

    @Step("Вычислить площадь круга с радиусом {0} и проверить результат {1}")
    void stepCalculateArea(double radius, double expected) {
        double area = Circle.calculateArea(radius);
        assertEquals(expected, area, 0.0001);
    }
}