package yugo.test_Epam_2;

import java.util.ArrayList;
import java.util.List;

public class Q15 {

        public static void main(String[] args) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            m1(list);
        }

        private static void m1(List<?> list) {
            m0(list); // line1
        }

        private static <T> void m0(List<T> list) {
            list.set(1, list.get(0)); // line2
            System.out.println(list);
        }
}
