package yugo.test_Epam_1;

import java.util.EnumMap;
import java.util.Map;

public class Q36_Another {

    public static void main(String[] args) {
        Map<Type, Integer> map = new EnumMap<>(Type.class);
        map.put(Type.FOUR, 5);
        map.put(Type.TWO, 7);
        map.put(Type.FOUR, 1);
        map.put(Type.ZERO, 3);

        for (Type i : map.keySet()) {
            System.out.print(i.ordinal() + " ");
        }
        System.out.println(map.values());
    }
}

enum Type {FOUR, TWO, ZERO}