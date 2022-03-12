package com.javalearning.katacalculator;

public class MyException extends Exception {
    public MyException() {
    }
    public MyException(String message) {
        System.err.println(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
