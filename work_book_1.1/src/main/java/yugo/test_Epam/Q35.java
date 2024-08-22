package yugo.test_Epam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q35 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(3);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);

        Iterator<Integer> iterator = list.iterator();
        list.sort((i1, i2) -> i2 - i1);
        list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
