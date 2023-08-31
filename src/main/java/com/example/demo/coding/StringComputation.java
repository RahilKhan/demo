package com.example.demo.coding;

public class StringComputation {

    public static void main(String... args) {

        String str = "cHaR";
        System.out.println("isUpper('" + str + "') -> " + str.equals(str.toUpperCase()));

        str = "CHAR";
        System.out.println("isUpper('" + str + "') -> " + str.equals(str.toUpperCase()));

    }


    public static boolean isUpper(String str) {
        for (char chr : str.toCharArray()) {
            if (!String.valueOf(chr).toUpperCase().equals(String.valueOf(chr))) {
                return false;
            }
        }
        return true;
    }

}
