package org.yg.MyTest;



import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.net.FileNameMap;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) throws Exception {
////        int a = 33;
////        int b = 5;
////        int c = a % b;  // 3
////        int d = 22 % 4; // 2 (22 - 4*5 = 2)
////
////        System.out.println(c);
//
////        Student st = new Student();
////            st.printSms("Hi, i'm maine class");
//
//        Student st = new Student();
//
//        st.setAge(20);
//        System.out.println(st.fulln());
//        System.out.println(st.getAge());
//
//        int age = st.getAge();
//        System.out.println(age);
//
//
        String hw = "hallo world";
        String[] strings = hw.split(" ");
        for (String string : strings) {
//            System.out.println(string);
            System.out.println(StringUtils.reverse(string));
//            System.out.println();
        }
//        for (String string : strings) {
//        String[] both = (String[])ArrayUtils.addAll(strings);
//            System.out.println(ArrayUtils.addAll(new String[]{string}));
//    }
//        List<String> alphabets = Arrays.asList("A", "B", "C", "D");
//        String delimiter = ",";
//
//        String result = "", prefix = "";
//        for (String s: alphabets)
//        {
//            result += prefix + s;
//            prefix = delimiter;
//        }
//
//        System.out.println(result);

    }
}

