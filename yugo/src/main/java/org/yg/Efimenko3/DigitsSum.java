package org.yg.Efimenko3;

public class DigitsSum {

    public int getDigits(String userLine) {
        int sum = 0;
        char[] charsOfLine = userLine.toCharArray();
        for (char symbol : charsOfLine) {
            if (symbol >= 48 && symbol <= 57) {
                sum = sum + Character.getNumericValue(symbol);
            }
        }
        return sum;
    }
}