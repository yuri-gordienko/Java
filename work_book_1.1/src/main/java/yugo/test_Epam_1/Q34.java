package yugo.test_Epam_1;

import java.util.HashSet;
import java.util.Set;

public class Q34 {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add(null);
        set.add(null);
        set.add("one");
        System.out.println(set);
    }
}
