package com.debanjan.exception;

public class MultiTry {
    public static void main(String[] args) {
        try {
            System.out.println("Within first try block , try to divide by zero");
            int value = 100 / 10;

            try {
                System.out.println("Within second try block , get the length of null string");
                String a = "xyz";
                a.length();

                try {
                    System.out.println("Within third try block , get the array out of index ");
                    int[] array = new int[3];
                    array[5] = 15;
                } catch (Exception e) {
                    System.out.println("Exception raised for third try block");
                    e.printStackTrace();
                }


            } catch (Exception e) {
                System.out.println("Exception raised for second try block");
                e.printStackTrace();
            }


        } catch (Exception e) {
            System.out.println("Exception raised for first try block");
            e.printStackTrace();

        }
    }
}
