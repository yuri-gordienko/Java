package yugo.test_Epam;

public class Q29_C2 {

    static String func(String str, String str1) {
        return str.replaceAll(str, str1);
    }

    public static void main(String[] args) {
        System.out.print(func("ab ab", "c"));
    }
}
