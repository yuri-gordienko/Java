package yugo.test_Epam_2;


import java.util.Set;
import java.util.TreeSet;

public class Q34 {

    static class Value implements Comparable<Value> {
        int val;

        Value(int v) {
            val = v;
        }

        @Override
        public int compareTo(Value other) {
            return Integer.compare(this.val, other.val);
        }
    }

        public static void main(String[] args) {
            TreeSet<Integer> integers = new TreeSet<>();
            Set<Value> values = new TreeSet<>();

            values.add(new Value(0));
            values.add(new Value(0));
            values.add(new Value(7));

            integers.add(0);
            integers.add(0);
            integers.add(7);

            System.out.println(values.size() + " " + integers.size());
        }

}
