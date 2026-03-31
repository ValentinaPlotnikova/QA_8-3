package org.example;

import java.util.Scanner;

public class Circle {

    public static double calculateArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Радиус не может быть отрицательным");
        }
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите радиус круга: ");
        double radius = scanner.nextDouble();

        try {
            double area = calculateArea(radius);
            System.out.println("Площадь круга: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}