package yugo.test_SoftServe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SoftServeMain {

//    3
//    private String str;
//    private int n;

//    4
//    private static String str;
//    private int n;

//    6
//    static String str = "Team 1";
//    static void change(int a) { a = 10; }
//    static void change(String str) { SoftServeMain.str = "Team 2"; }

//    7
//    static final int number = 10;
//    final int getNumber(int n1, int n2) {
//        int number = 20;
//        return n1 < n2 ? n1 : n1 > n2 ? n2 : number;
//    }



    public static void main(String[] args) {

//        3
//        System.out.printf("Strings is " + str);
//        System.out.printf("\nInteger equels " + n);

//        4
//        System.out.printf("Strings is " + str);
//        System.out.printf("\nInteger equels " + n);

//        6
//        int a = 5;
//        change(a);
//        change(str);
//        System.out.printf(str + " " + a);

//        7
//        SoftServeMain softServeMain = new SoftServeMain();
//        int number = 15;
//        System.out.printf(softServeMain.getNumber(number, SoftServeMain.number)));

//        10
//        boolean a =    ;
//        boolean b = true;
//        boolean c =    ;
//        System.out.println(!a || b && !c);

//        13
//        for (byte i = 126; i <= 127 ; i++) {
//            System.out.println(i);
//        }

//        14
//        for (short i = 32766; i <= 32766; i = i+1) {
//            System.out.println(i);
//        }

//        15
//        int n = -1;
//        while (++n < 5) {
//            for (int i = 0; i < n -1; i++) {
//                System.out.println('*');
//            }
//            System.out.println();
//        }

//        16
//        int i;
//        int sum = 1;
//        for (int j = 1; j <=10 ; j++) {
//            sum +=j;
//        }
//        System.out.println("sum " + sum);

//        21
//        String str1 = "IT weekend";
//        String str2 = "IT academy";
//        System.out.println(str2.startsWith("IT") && str1.endsWith("end"));

//        23
//        String s1 = "abc";
//        StringBuffer s2 = new StringBuffer(s1);
//        System.out.println(s1.equals(s2));

//        29
//        List<String> list = Arrays.asList("str1", "str2", "str3", "str4");
//        System.out.println(list.get(list.size() - 4));

//        30
//        List<Integer> s1 = new ArrayList<Integer>();
//        s1.add(5);
//        s1.add(8);
//        s1.add(1, 2);
//        List<Integer> s2 = new ArrayList<Integer>(s1.subList(1, 2));
//        s1.addAll(s2);
//        System.out.println(s1);

//        31
//        List<Integer> s1 = new ArrayList<Integer>();
//        s1.add(5);
//        s1.add(8);
//        s1.add(1, 2);
//        List<Integer> s2 = new ArrayList<Integer>(s1.subList(1, 1));
//        s1.addAll(s2);
//        System.out.println(s1);

//        34
//        List<Integer> list = Arrays.asList(10, 5, 1, 3, 7);
//        int max = list.stream()
//                .filter(a -> a < 7)
//                .max(Comparator.comparing(Integer::valueOf))
//                .get();
//        System.out.println(max);

//        35
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        list.stream()
                .filter((n) -> n > 3)
                .forEach(System.out::print);
    }
}
