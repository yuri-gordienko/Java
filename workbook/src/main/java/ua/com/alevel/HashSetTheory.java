package ua.com.alevel;

import java.util.HashSet;

public class HashSetTheory {

    public static void main(String[] args) {
// A HashSet is a collection of items where every item is unique, and it is found in the java.util package:
// Methods: add, contains, remove, clear, size, Loop Through
        HashSet<String> cars = new HashSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");
        System.out.println(cars);
// Note: In the example above, even though BMW is added twice it only appears once in the set because every
// item in a set has to be unique.

// To check whether an item exists in a HashSet, use the contains() method:
        System.out.println("exist - " + cars.contains("BMW"));
        System.out.println("exist - " + cars.contains("Bmv"));
        System.out.println("exist - " + cars.contains("Honda"));

        System.out.println("");
        cars.remove("Volvo");
        System.out.println(cars);
        System.out.println(cars.size());

        System.out.println("");
        for (String i : cars) {
            System.out.println("loop - " + i);
        }

        // Show which numbers between 1 and 10 are in the set
        System.out.println("");
        HashSet<Integer> num = new HashSet<>();
        num.add(4);
        num.add(2);
        num.add(6);
        num.add(9);
        System.out.println(num);
        System.out.println(num.size());
        System.out.println(num.contains(1));

        System.out.println("");
        for (int i = 1; i <=10; i++) {
            if (num.contains(i)) {
                System.out.println(i + " - exist");
            }
            else  {
                System.out.println(i + " - not exist");
            }
        }
    }
}
