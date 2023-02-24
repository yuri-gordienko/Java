package ua.com.alevel;

public class Numbers {
    public int getNumbers(String count) {
        char[] charsNum = count.toCharArray();
        int sum = 0;
        for (char c : charsNum) {
            if (c <= 57 && c >= 48) {
                sum = sum + Character.getNumericValue(c);
            }
        }
        return (sum);
    }
}
