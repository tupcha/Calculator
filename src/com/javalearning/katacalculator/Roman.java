package com.javalearning.katacalculator;

public enum Roman {
    I(1), IV(4), V(5) , IX(9), X(10), L(50), C(100);


    private final int value;

    Roman(int value) {
        this.value = value;
    }

    public int getVallue() {
        return value;
    } /* Метод гет для значений Enum */


    /*Операции для римских  чисел [+, -, /, *]  */
    public static String sum(String firstNumber, String secondNumber) {
        int res =Converters.convertToArabian(firstNumber) + Converters.convertToArabian(secondNumber);
        return Converters.convertToRoman(res);
    }

    public static String subtraction(String firstNumber, String secondNumber) {
        int res = Converters.convertToArabian(firstNumber) - Converters.convertToArabian(secondNumber);
        return Converters.convertToRoman(res);
    }

    public static String division(String firstNumber, String secondNumber) {
        int res = Converters.convertToArabian(firstNumber) / Converters.convertToArabian(secondNumber);
        return Converters.convertToRoman(res);
    }

    public static String multiplication(String firstNumber, String secondNumber) {
        int res = Converters.convertToArabian(firstNumber) * Converters.convertToArabian(secondNumber);
        return Converters.convertToRoman(res);
    }
}
