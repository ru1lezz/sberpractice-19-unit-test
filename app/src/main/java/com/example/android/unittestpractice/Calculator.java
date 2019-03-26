package com.example.android.unittestpractice;

public class Calculator {

    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double divide(double firstNumber, double secondNumber) {
        if(secondNumber == 0)
            throw new ArithmeticException();
        return firstNumber / secondNumber;
    }

    public double sqrt(double firstNumber) {
        return Math.sqrt(firstNumber);
    }
}
