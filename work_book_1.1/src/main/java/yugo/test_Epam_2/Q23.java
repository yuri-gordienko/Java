package yugo.test_Epam_2;

import java.util.Optional;
import java.util.stream.Stream;

public class Q23 {

        public static void main(String args[]) {
            Stream.of("java", "hello ", null).forEach(Q23::up);
        }

    private static void up(String str) {
        Optional<String> string = Optional.ofNullable(str);
        System.out.print(string.map(String::toUpperCase).orElse("start"));
    }
}
