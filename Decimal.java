package com.company;

public class Decimal implements INumber {
    private final int numerator;
    private final int denominator;

    public Decimal(int numerator, int denominator) throws IllegalArgumentException{
        if(denominator == 0) throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Decimal() {
        this(1, 1);
    }

    @Override
    public double sum(INumber number) throws IllegalArgumentException {
        if (number == null) throw new IllegalArgumentException("Аргумент не задан: argument is null");
        if (!(number instanceof Decimal)) throw new IllegalArgumentException("Суммировать можно только дроби");
        return this.getValue() + number.getValue();
    }

    @Override
    public INumber add(INumber number) throws IllegalArgumentException {
        if (number == null) throw new IllegalArgumentException("Аргумент не задан: argument is null");
        if (!(number instanceof Decimal)) throw new IllegalArgumentException("Суммировать можно только дроби");
        if (denominator != ((Decimal) number).denominator) {
            return new Decimal(numerator * ((Decimal) number).denominator
                    + ((Decimal) number).numerator * denominator, denominator * ((Decimal) number).denominator);
        } else {
            return new Decimal(numerator + ((Decimal) number).numerator, denominator);
        }
    }

    public static Decimal add(Decimal number, Decimal number2) throws IllegalArgumentException {
        if (number == null || number2 == null)
            throw new IllegalArgumentException("Аргументы не заданы: argument is null");

        if (number.denominator != number2.denominator) {
            return new Decimal(number.numerator * number.denominator
                    + number2.numerator * number.denominator, number.denominator * number2.denominator);
        } else {
            return new Decimal(number.numerator + number2.numerator, number.denominator);
        }
    }

    @Override
    public double sub(INumber number) {
        if (number == null) throw new IllegalArgumentException("Аргумент не задан: argument is null");
        if (!(number instanceof Decimal)) throw new IllegalArgumentException("Вычитать можно только дроби");
        return getValue() - number.getValue();
    }

    @Override
    public INumber subtract(INumber number) {
        if (number == null) throw new IllegalArgumentException("Аргумент не задан: argument is null");
        if (!(number instanceof Decimal)) throw new IllegalArgumentException("Вычитать можно только дроби");
        if (denominator != ((Decimal) number).denominator) {
            return new Decimal(numerator * ((Decimal) number).denominator
                    - ((Decimal) number).numerator * denominator, denominator * ((Decimal) number).denominator);
        } else {
            return new Decimal(numerator - ((Decimal) number).numerator, denominator);
        }
    }

    public static Decimal subtract(Decimal number, Decimal number2) throws IllegalArgumentException {
        if (number == null || number2 == null)
            throw new IllegalArgumentException("Аргументы не заданы: argument is null");

        if (number.denominator != number2.denominator) {
            return new Decimal(number.numerator * number.denominator
                    - number2.numerator * number.denominator, number.denominator * number2.denominator);
        } else {
            return new Decimal(number.numerator - number2.numerator, number.denominator);
        }
    }


    @Override
    public double mult(INumber number) throws IllegalArgumentException{
        if (number == null) throw new IllegalArgumentException("Аргумент не задан: argument is null");
        if (!(number instanceof Decimal)) throw new IllegalArgumentException("Умножать можно только дроби");
        return getValue() * number.getValue();
    }

    @Override
    public INumber multiply(INumber number) throws IllegalArgumentException{
        if (number == null) throw new IllegalArgumentException("Аргумент не задан: argument is null");
        if (!(number instanceof Decimal)) throw new IllegalArgumentException("Умноженать можно только дроби");
        return new Decimal(numerator * ((Decimal) number).numerator, denominator * ((Decimal) number).denominator);
    }

    public static INumber multiply(Decimal number, Decimal number2) throws IllegalArgumentException{
        if (number == null || number2 == null)
            throw new IllegalArgumentException("Аргументы не заданы: argument is null");
        return new Decimal(number.numerator * number2.numerator, number.denominator * number2.denominator);
    }

    @Override
    public double divide(INumber number) {
        if (number == null) throw new IllegalArgumentException("Аргумент не задан: argument is null");
        if (!(number instanceof Decimal)) throw new IllegalArgumentException("Делить можно только дроби");
        if(number.getValue() == 0) throw new ArithmeticException("Деление на 0");
        return getValue() / number.getValue();
    }

    @Override
    public INumber division(INumber number) {
        if (number == null) throw new IllegalArgumentException("Аргумент не задан: argument is null");
        if (!(number instanceof Decimal)) throw new IllegalArgumentException("Делить можно только дроби");
        if(number.getValue() == 0) throw new ArithmeticException("Деление на 0");
        return new Decimal(numerator * ((Decimal) number).denominator, denominator * ((Decimal) number).numerator);
    }

    public static INumber division(Decimal number, Decimal number2) throws IllegalArgumentException{
        if (number == null || number2 == null)
            throw new IllegalArgumentException("Аргументы не заданы: argument is null");
        if(number2.getValue() == 0) throw new ArithmeticException("Деление на 0");
        return new Decimal(number.numerator * number2.denominator, number.denominator * number2.numerator);
    }

    @Override
    public double getValue() throws ArithmeticException {
        if (denominator == 0) throw new ArithmeticException("Знаменатель равен 0");
        return (double) numerator / (double) denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

}
