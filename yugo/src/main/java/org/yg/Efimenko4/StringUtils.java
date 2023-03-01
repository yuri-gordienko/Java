package org.yg.Efimenko4;

public class StringUtils {
    public static String reverse(String userString) {
        char[] charArrOfUserString = userString.toCharArray();
        int end = charArrOfUserString.length - 1;
        for (int i = 0; i < charArrOfUserString.length / 2; i++) {
            char temp;
            temp = charArrOfUserString[end];
            charArrOfUserString[end] = charArrOfUserString[i];
            charArrOfUserString[i] = temp;
            end--;
        }
        return new String(charArrOfUserString);
    }

    public static String reverse(String userString, String dest) {
        int index = userString.indexOf(dest);
        if (index > 0) {
            String reversedString = reverse(dest);
            return userString.replace(dest, reversedString);
        }
        return "there is no such substring in your String";
    }

    public static String reverse(String userString, int firstIndex, int
            lastIndex) {
        if (firstIndex >= 0 && lastIndex > 0 && lastIndex < userString.length()
                && firstIndex < lastIndex) {
            String toReverse = userString.substring(firstIndex, lastIndex + 1);
            String reversedString = reverse(toReverse);
            return userString.replace(toReverse, reversedString);
        }
        return "something goes wrong, enter valid data";
    }
}