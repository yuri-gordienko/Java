package ua.com.alevel.String;

public class StringCompare {

    public static void main(String[] args) {

        // how to compare primitives
        int a = 10;
        int b = 15;
        int c = 5;
        int d = 10;

        System.out.println(a == b);     // for compare primitives use ==
        System.out.println(a == d);
        System.out.println(a + c == b);

        System.out.println("_______________________________________________________________");

        // how to compare Strings
        String f = "hello";
        String g = "world";
        String h = "world";

        System.out.println(f == g);
        System.out.println(g == h);
        System.out.println(f.equals(g));    // for compare objects use method equals
        System.out.println(g.equals(h));

        System.out.println("_______________________________________________________________");

        String stat = "100001";
        char[] chars = stat.toCharArray();

        double count = 0.0;

        if (stat.equals("")){
            System.out.println("0.0");
        }
        for (char s : chars) {
            if (s == '1') {
                count += 1.0;
            }
        }

        double statistic = count / chars.length;
        System.out.println(statistic);
        System.out.println(chars.length);

        System.out.println("_______________________________________________________________");


//    public class CompareStrings {
//        public static boolean compareStrings(String firstString, String secondString) {
//            // Перевірка на випадок, коли обидва рядки є null
//            if (firstString == null && secondString == null) {
//                return true;
//            }
//
//            // Порівнюємо рядки
//            return (firstString != null) && firstString.equals(secondString);
//        }
//    }
    }


}
