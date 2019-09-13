package com.debanjan.exception;

public class MultiCatch {

    public static void main(String[] args) {


        try {
            String value = null;
            value.length();
        } catch (ArithmeticException e) {
            System.out.println("Exception Raised for Arithmetic");
            System.out.println("Details: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception raised");
            e.printStackTrace();
        }
    }
}
