package yugo.test_Epam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q26_Mr2 {

    public static void main(String[] args) {
        List<Employee> list = List.of(
                new Employee(11, "Jan"),
                new Employee(9, "Kostus"),
                new Employee(7, "Jan")
        );
        list.forEach(System.out::println);
        System.out.println(" ");

        List<Employee> sortedList = list.stream()
                .sorted(Comparator.comparing(Employee::name)
                        .thenComparing(Employee::id))
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);
        System.out.println(" ");


        List<Employee> sortedList2 = list.stream()
                .sorted(Comparator.comparing(Employee::id)
                        .thenComparing(Employee::name))
                .collect(Collectors.toList());

        sortedList2.forEach(System.out::println);
    }

}

record Employee(int id, String name) {}
