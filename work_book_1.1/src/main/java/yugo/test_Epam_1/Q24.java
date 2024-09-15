package yugo.test_Epam_1;

import java.util.HashMap;
import java.util.Map;

public class Q24 {

    public static void main(String[] args) {

        String[] strings = {"aa", "bb", "aaa", "cc", "aa", "bbb"};
        Map<String, Integer> map = new HashMap<>();
        for(String s :strings) {
            map.merge(s + 'a', 1, (o, n) -> o + n);
        }

        var result = map.compute("aaa", (k, v) -> k.length() + v);
        System.out.println(result);
    }
}
