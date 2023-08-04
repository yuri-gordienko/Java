package ua.com.alevel;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        int sum = sumFunc(10, 12);
    }

    public static int sumFunc(int a, int b) {
        int result = a + b;
        System.out.println(result);
        return result;
    }
}
