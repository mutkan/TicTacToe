package com.mutlucelep.tictactoe.utility;

public class StringUtility {
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.length() == 0;
    }

    public static String stringFromNumbers(int... numbers){
        StringBuilder sNumbers = new StringBuilder();
        for (int n:numbers){
            sNumbers.append(n);
        }
        return sNumbers.toString();
    }
}
