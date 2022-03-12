package com.javalearning.katacalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MyException {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите выражение:" );
                Operation operation = new Operation(scanner.nextLine());
                System.out.println("Ответ: " + (operation.flagRoman ? operation.resultForRoman() : operation.resultForArabic()));
            } catch (MyException e) {
                e.getMessage();
                System.out.print("Попробуйте еще раз: ");
            }
        }
    }
}


