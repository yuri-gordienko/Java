package ua.com.alevel.String;

public class StringCompare {

    public static void main(String[] args) {

        // how to compare primitives
        int a = 10;
        int b = 15;
        int c = 5;
        int d = 10;

        System.out.println(a == b);
        System.out.println(a == d);
        System.out.println(a + c == b);

        System.out.println("_______________________________________________________________");

        // how to compare Strings
        String f = "hello";
        String g = "world";
        String h = "world";

        System.out.println(f == g);
        System.out.println(g == h);
        System.out.println(f.equals(g));
        System.out.println(g.equals(h));
    }
}
