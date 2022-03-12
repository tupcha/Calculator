package com.javalearning.katacalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MyException {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                Operation operation = new Operation(scanner.nextLine());
                System.out.println(operation.flagRoman ? operation.resultForRoman() : operation.resultForArabic());
            } catch (MyException e) {
                e.getMessage();
            }
        }
    }
}


