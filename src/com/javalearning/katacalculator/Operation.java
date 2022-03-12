package com.javalearning.katacalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operation { //класс операции

    public List<String> ListNumbers = new ArrayList<>();
    private static final List<String> validArabicValues = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    private static final List<String> validRomanValues = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    private static final List<String> validOperand = Arrays.asList("+", "-", "/", "*");

    private final String firstNumber;
    private final String secondNumber;
    private final String operation;

    public boolean flagRoman;


    public Operation(String str) throws MyException {
        String[] masStr = str.trim().split(" ");
        if (masStr.length < 3) {
            /*Проверка на 1-ин введеный символ */
            throw new MyException("throws Exception //т.к. строка не является математической операцией");
        }
        this.ListNumbers.addAll(Arrays.asList(masStr));
        this.firstNumber = ListNumbers.get(0);
        this.secondNumber = ListNumbers.get(ListNumbers.size() - 1);
        this.operation = ListNumbers.get(1);

        if (masStr.length > 3) {
            /*Проверка на операции с более чем двумя операндами */
            throw new MyException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (!validOperand.contains(operation)) {
            throw new MyException("throws Exception //т.к.  Неизвестный  операнд, используйте: (+, -, /, *) ");
        } else if ((!validArabicValues.contains(firstNumber) && !validRomanValues.contains(firstNumber)) ||
                (!validArabicValues.contains(secondNumber) && !validRomanValues.contains(secondNumber))) {
            throw new MyException("throws Exception //т.к. Данные числвоые значения  не  поддерживаются калькулятором,  введите числа в диапазоне 1-10");
        } else if (((validArabicValues.contains(firstNumber) && validRomanValues.contains(secondNumber)) ||
                (validArabicValues.contains(secondNumber) && validRomanValues.contains(firstNumber)))) {
            throw new MyException("throws Exception //т.к. используются одновременно разные системы счисления");
        } else if (validRomanValues.contains(firstNumber)) {
            flagRoman = true;
            if (operation.equals("-") && (Converters.convertToArabian(firstNumber) <= Converters.convertToArabian(secondNumber))) {
                throw new MyException("throws Exception//т.к. в  римской системе нет отрицательных чисел или 0");
            }
        } else {
            flagRoman = false;

        }
    }


    public String resultForRoman() {
        return switch (operation) {
            case "+" -> Roman.sum(firstNumber, secondNumber);
            case "-" -> Roman.subtraction(firstNumber, secondNumber);
            case "*" -> Roman.multiplication(firstNumber, secondNumber);
            case "/" -> Roman.division(firstNumber, secondNumber);
            default -> null;
        };
    }


    public int resultForArabic() {
        return switch (operation) {
            case "+" -> Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
            case "-" -> Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
            case "*" -> Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
            case "/" -> Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
            default -> 0;
        };
    }

}



