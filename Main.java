package com.company;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        Decimal decimal = null, decimal2 = null;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Введите числитель для первой дроби: ");
                int numerator1 = scanner.nextInt();
                System.out.println("Введите знаменатель для первой дроби: ");
                int denominator1 = scanner.nextInt();
                decimal = new Decimal(numerator1, denominator1); // 1/4 - 4/7
                System.out.println("Введите числитель для второй дроби: ");
                int numerator2 = scanner.nextInt();
                System.out.println("Введите знаменатель для второй дроби: ");
                int denominator2 = scanner.nextInt();
                decimal2 = new Decimal(numerator2, denominator2); // 7/28 - 16/28
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (decimal == null || decimal2 == null);

        while (true) {
            System.out.println("""
                    Выберите действия:
                    1.Сложить две дроби
                    2.Вычитать из 1 вторую
                    3.Вычитать из 2 первую
                    4.Умножить две дроби
                    5.Поделить первую на вторую
                    6.Поделить вторую на первую
                    7.Выйти
                    """);
            int answer = scanner.nextInt();
            try {
                switch (answer) {
                    case 1 ->
                            System.out.println(decimal.add(decimal2).toString());
                    case 2 ->
                            System.out.println(decimal.subtract(decimal2).toString());
                    case 3 ->
                            System.out.println(Decimal.subtract(decimal2, decimal).toString());
                    case 4 ->
                            System.out.println(decimal.multiply(decimal2).toString());
                    case 5 ->
                            System.out.println(decimal.division(decimal2).toString());
                    case 6 ->
                            System.out.println(Decimal.division(decimal2, decimal).toString());
                    case 7 -> {
                        scanner.close();
                        exit(0);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}
