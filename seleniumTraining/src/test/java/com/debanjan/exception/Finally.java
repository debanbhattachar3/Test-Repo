package com.debanjan.exception;

public class Finally {

    public static void main(String[] args) {


        try{
            String name = "xyz";
            String value = null;
            System.out.println("Hi " + name);
            value.length();
        }catch (Exception e){
            System.out.println("Exception raised");
            e.printStackTrace();
            //System.exit(0);
        }finally {
            System.out.println("At finally block");
        }
    }
}
