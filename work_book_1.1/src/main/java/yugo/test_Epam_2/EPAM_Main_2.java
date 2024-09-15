package yugo.test_Epam_2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class EPAM_Main_2 {

    public static void main(String[] args) {
        long i = 1;

//        2
//        int i = 2;
//        int j = 10;
//        i = switch (i) {
//            case 1 -> --j;
//            case 2, 3 -> --j;
//            case 4 -> --j;
//            case 5 -> --j;
//            default -> {
//                System.out.print(i + j + " ");
//                yield i + j;
//            }
//        };
//        System.out.println(i);


//        4
//        boolean flag = true ^ false;
//        System.out.println(!flag);


//        6
//        int a = 1;
//        boolean match = true;
//        for (int i = 0; i < 3; i++) {
//            while (match) {
//                a++;
//                if (i > a || a > 5) {
//                    match = false;
//                }
//            }
//            System.out.print(a);
//        }

//        7
//        String[][][] arr = {
//                { {}, null },
//                { { "5", "8"}, { "2", null, "1" } },
//                {},
//                { {"4", null } }
//        };
//        System.out.print(arr.length + arr[1][2].length);


//        23
//        try {
//            int x = 0, y;
//            y = 7 / x;
//            System.out.print("A");
//        }
//        catch(ArithmeticException e) {
//            System.out.print("B");
//        } finally {
//            System.out.print("C");
//        }

//        24
//        String[] strings = {"aa", "bb", "aaa", "cc", "aaaa", "bbb"};
//        Map<String, Integer> map = new HashMap<>();
//        for (String s : strings) {
//            map.merge(s, 1, (o, n) -> o + n);
//        }
//        var result = map.computeIfAbsent("ccc", k -> k.length());
//        System.out.println(result);


//        27
//        int res = IntStream.of(1, 3, 4)
//                .reduce(0, (num1, num2) -> (num1 + num2) * 2);
//        System.out.println(res);


//        31
//        InputStream in = System.in;
//        byte b[] = {};
//        int n = 0;
//        try {
//            n = in.read(b);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(n);


//        33
//        String s1 = new String(new char []{'A', 'B', 'C'}), s2 = "ABC";
//        StringBuffer sb1= new StringBuffer(s1);
//        StringBuffer sb2 = new StringBuffer(s2);
//        boolean b1 = s1.hashCode() == s2.hashCode();  // Порівняння хеш-кодів для s1 і s2
//        boolean b2 = sb1.hashCode() == sb2.hashCode();  // Порівняння хеш-кодів для sb1 і sb2
//        System.out.print(b1 + " " + b2);


//        39
//        int result = 0;
//        for (int i = 5; i > 2; ++i, i = i - 2) {
//            result += i;
//            System.out.print("A");
//        }
//        System.out.print(result);
    }
}
