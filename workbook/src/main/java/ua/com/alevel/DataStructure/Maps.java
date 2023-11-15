package ua.com.alevel.DataStructure;

import java.util.*;

public class Maps {

    public static void main(String[] args) {

        test();
    }

    private static final Map<String, String> hashMap = new HashMap<>(); // зберігає у рандомному порядку
    private static final Map<String, String> linkedHashMap = new LinkedHashMap<>(); // зберігає у порядку додавання
    private static final Map<String, String> treehMap = new TreeMap<>(); // елементи відсортовани за ключем,
    // також можна сортувати по філдам, але треба перевизначити метод CompareTo у Ентіті класі
    // та вказати що клас implements Comparable<Student>

    private static void test() {
        hashMap.put("1", "v1.1");
        System.out.println("First put - " + hashMap);
        hashMap.put("1", "v1.2");
        System.out.println("Second put - " + hashMap);    // перезаписала перше значення
        hashMap.put("2", "v2.1");
        System.out.println("Third put - " + hashMap);
        hashMap.put("22", "v2.1");
        hashMap.put("25", "v2.1");
        System.out.println("\nHashMap: " + hashMap);

        Collection<String> values = hashMap.values();
        System.out.println("Values: " + values);

        Collection<String> keys = hashMap.keySet();
        System.out.println("Keys: " + keys);

        String value = hashMap.get("2");    // отримали значення за ключем
        System.out.println("Get by key - " + value);

        hashMap.remove("1");
        System.out.println("HashMap after removing by key: " + hashMap);

        keys = hashMap.keySet();
        System.out.println("Keys: " + keys);


//        hashMap.clear();                  // вичистили усю мапу
//        System.out.println("Clear: " + hashMap);
//------------------------------------------------------------------------------------------------

        linkedHashMap.put("1", "v1.1");
        System.out.println("\nFirst put - " + linkedHashMap);
        linkedHashMap.put("1", "v1.2");
        System.out.println("Second put - " + linkedHashMap);    // перезаписала перше значення
        linkedHashMap.put("2", "v2.1");
        System.out.println("Third put - " + linkedHashMap);
        linkedHashMap.put("22", "v2.1");
        linkedHashMap.put("17", "v0.1");
        System.out.println("LinkedHashMap: " + linkedHashMap);
        linkedHashMap.forEach((String k, String v) -> {          // Лямбда вираз з типами значень
            System.out.println("k - " + k);
        });
//-----------------------------------------------------------------------------------------------------

        treehMap.put("100", "v1.1");
        System.out.println("\nFirst put - " + treehMap);
        treehMap.put("1", "v1.2");
        System.out.println("Second put - " + treehMap);
        treehMap.put("25", "v2.1");
        System.out.println("Third put - " + treehMap);
        treehMap.put("22", "v2.1");
        treehMap.put("17", "v1.1");
        System.out.println("\treehMap: " + treehMap);
        treehMap.forEach((k, v) -> {                   // Лямбда вираз, без типов значень, т.я вони вказані в Мапі
            System.out.println("k - " + k);
        });
    }
//----------------------------------------------------------------------------------------------------------

// Приклади перевизначення методів у Entity класі:

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Student student)) return false;
//
//        if (age != student.age) return false;
//        if (!Objects.equals(firstName, student.firstName)) return false;
//        return Objects.equals(lastName, student.lastName);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = firstName != null ? firstName.hashCode() : 0;
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        result = 31 * result + age;
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", age=" + age +
//                '}';
//    }
//
//    @Override
//    public int compareTo(Student o) {
//        if (this.getAge() > o.getAge()) {
//            return 1;
//        } else if (this.getAge() < o.getAge()) {
//            return -1;
//        }
//        int compareByFistName = this.firstName.compareTo(o.getFirstName());
//        if (compareByFistName == 0) {
//            return this.lastName.compareTo(o.getLastName());
//        }
//        return compareByFistName;
//    }
}
