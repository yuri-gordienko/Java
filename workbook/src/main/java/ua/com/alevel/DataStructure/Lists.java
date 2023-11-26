package ua.com.alevel.DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {

    public static void main(String[] args) {

        test();
    }

    private final static int SIZE = 2_900_000;

    public static void test() {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        Long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i); // O(n) - швидше Лінкед листа, додає по порядочку
            arrayList.get(i); // O(1) - швидше Лінкед листа, шукає по індексу по порядочку
            arrayList.set(i, i + 1); // (update), O(1) - швидше Лінкед листа, шукає по індексу по порядочку
            arrayList.remove(i); // (delete) O(n) - довше Лінкед листа, створює новий масив -> перезаписує туди новий і так на кожній етераціїї
        }
        Long end = System.currentTimeMillis() - start;
        System.out.println("ArrayList add: " + end);
        System.out.println("ArrayList get: " + end);
        System.out.println("ArrayList set: " + end);

//-------------------------------------------------------------------
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(i); // O(n) - при додаванні створює новий об'єкт
            linkedList.get(i); // O(n) - шукає перебираючи всі об'єкти, доки не знайде потрібний
            linkedList.set(i, i + 1); // (update), O(n) - шукає перебираючи всі об'єкти, доки не знайде потрібний
            linkedList.remove(i); // O(1) - перезаписує посилання у нодах, значно швидше Ерей листа
        }
        end = System.currentTimeMillis() - start;
        System.out.println("LinkedList add: " + end);
        System.out.println("LinkedList get: " + end);
        System.out.println("LinkedList set: " + end);
    }
}
