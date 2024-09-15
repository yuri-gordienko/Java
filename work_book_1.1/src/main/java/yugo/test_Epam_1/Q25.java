package yugo.test_Epam_1;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Q25 {

    public static void main(String[] args) {

        Predicate<? super String> predicate = s -> s.startsWith("J");
        Stream<String> stream1 = Stream.generate(() -> "Java");
        Stream<String> stream2 = Stream.generate(() -> "Java19");
        boolean b1 = stream1.anyMatch(predicate);
        boolean b2 = stream2.allMatch(predicate);
        System.out.println(b1 + " " + b2);
    }
}
