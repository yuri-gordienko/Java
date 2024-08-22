package yugo.test_Epam;

import java.util.Arrays;
import java.util.List;

public class Q27 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum = list.stream()
                .reduce(1, Integer::sum);
        System.out.println(sum);
    }
}
