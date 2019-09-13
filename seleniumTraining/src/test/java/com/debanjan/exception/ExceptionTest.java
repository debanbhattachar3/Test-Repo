package com.debanjan.exception;

public class ExceptionTest {

    public static void main(String[] args) {

        try {
            int value = 100;
            int value1 = 10;
            int result = value / value1;
            System.out.println("The result is: " + result);
        } catch (Exception exception) {
            System.out.println("Exception raised, you can't divide by zero");
            System.out.println("Exception Details: " + exception.getMessage().toString());
        }
    }
}
