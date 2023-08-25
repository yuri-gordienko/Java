package ua.com.alevel;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTheory {

    public static void main(String[] args){
//Methods: add, get, set, remove, clear
//size
//size() method to specify how many times the loop should run
//for-each loop
//add elements of type Integer
//sort()
        ArrayList <String>cars = new ArrayList<>();
        cars.add("ford");
        cars.add("mers");
        cars.add("bmw");
        cars.add("honda");
        System.out.println(cars);
        System.out.println("cars size - " + cars.size());

        cars.set(0, "renault");
//            System.out.println("set - " + cars);
//
//            cars.remove(0);
//            System.out.println("remove - " + cars);

        for (int i = 0; i < cars.size(); i++) {
            System.out.println(i);
//            System.out.println(cars.get(i));
//            System.out.println("get - " + cars.get(1));
        }
        System.out.println(" ");

        for (String i : cars) {
            System.out.println(i);
        }


        ArrayList <Integer>num = new ArrayList<>();
        num.add(10);
        num.add(6);
        num.add(20);
        num.add(15);
        System.out.println(num);

        Collections.sort(num);
        System.out.println(num);
    }
}

//    How the ArrayList works
//    The ArrayList class has a regular array inside it. When an element is added, it is placed into the array.
//    If the array is not big enough, a new, larger array is created to replace the old one and the old one is removed.
//
//        How the LinkedList works
//        The LinkedList stores its items in "containers." The list has a link to the first container and each
//        container has a link to the next container in the list. To add an element to the list, the element is
//        placed into a new container and that container is linked to one of the other containers in the list.
//
//        When To Use
//        Use an ArrayList for storing and accessing data, and LinkedList to manipulate data.

























