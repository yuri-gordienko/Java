package ua.com.alevel;

import java.util.HashMap;

public class HashMapTheory {

// In the ArrayList chapter, you learned that Arrays store items as an ordered collection, and you have to access
// them with an index number (int type). A HashMap however, store items in "key/value" pairs, and you can access
// them by an index of another type (e.g. a String).

// One object is used as a key (index) to another object (value). It can store different types: String keys and
// Integer values, or the same type, like: String keys and String values:

    public static void main(String[] args){
//Methods: put, get, remove, clear, size, Loop Through a HashMap,

        HashMap<String, String> cities = new HashMap<>();
        cities.put("Ukr", "Kiev");
        cities.put("Ger", "Berl");
        cities.put("USA", "Wash");
        System.out.println("size - " + cities.size());
        cities.put("Ger", "Bon");
        System.out.println(cities);
        System.out.println("key - " + cities.get("Ger"));

        for (String i : cities.keySet()) {
            System.out.println("keys - " + i);
        }

        System.out.println(" ");
        for (String i : cities.values())
            System.out.println("values - " + i);

        System.out.println(" ");
        for (String i : cities.keySet())
        System.out.println("k - " + i + ", val - " + cities.get(i));

    }
}
