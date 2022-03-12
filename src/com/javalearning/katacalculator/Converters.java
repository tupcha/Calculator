package com.javalearning.katacalculator;

public class Converters {
    /* Перевод  из арабского чиса в римское */
    public static String convertToRoman(int res) {
        StringBuilder sb = new StringBuilder();
        Roman[] valueRoman = Roman.values();
        for (int i = valueRoman.length - 1; i >= 0; i--) {
            while (res >= valueRoman[i].getVallue()) {
                sb.append(valueRoman[i]);
                res -= valueRoman[i].getVallue();
            }
        }
        return sb.toString();
    }

    /* Из строки в число, работает только под условие задачи */
    public static int convertToArabian(String str) {
        String[] mass = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int[] arrMass = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = 0;
        for (int i = 0; i < mass.length; i++) {
            if (str.equals(mass[i])) {
                result = arrMass[i];
            }
        }
        return result;
    }

}
