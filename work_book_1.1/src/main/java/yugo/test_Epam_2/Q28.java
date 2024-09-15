package yugo.test_Epam_2;

public class Q28 {

        static String f(String str) {
            return String.valueOf(str.concat("a").length());
        }

        public static void main(String[] args) {
            System.out.println(f("ab ab"));
        }
}
