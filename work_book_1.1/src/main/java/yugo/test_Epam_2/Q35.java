package yugo.test_Epam_2;

import java.util.*;

public class Q35 {

    public static void main(String[] args) {
        List<String> s1 = new ArrayList<>();
        s1.add("a");
        s1.add("b");
        s1.add(0, "c");

        Queue<String> s2 = new PriorityQueue<>(s1.subList(1, 2));
        s1.addAll(s2);
        System.out.println(s1);
    }
}
