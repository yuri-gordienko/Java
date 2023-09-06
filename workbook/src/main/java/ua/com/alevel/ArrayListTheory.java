package ua.com.alevel;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTheory {

// The ArrayList class is a resizable array, which can be found in the java.util package.
// The difference between a built-in array and an ArrayList in Java, is that the size of an array cannot be modified
// (if you want to add or remove elements to/from an array, you have to create a new one). While elements can be added
// and removed from an ArrayList whenever you want. The syntax is also slightly different:

    public static void main(String[] args){
//Methods: add, get, set, remove, clear, size,
// size() method to specify how many times the loop should run,  for-each loop
//add elements of type Integer
//sort()
        ArrayList<String> cars = new ArrayList<>();
        cars.add("ford");
        cars.add("mers");
        cars.add("bmw");
        cars.add("honda");
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



//    public static void main(String[] args) {
//        int[] speeds1 = new int[]{60, 70, 50, 80, 90};
//        int[] speeds2 = {100};
//        int[] speeds3 = {};
//
//        int[] stats1 = getSpeedStatistic(speeds1);
//        int[] stats2 = getSpeedStatistic(speeds2);
//        int[] stats3 = getSpeedStatistic(speeds3);
//
//        System.out.println("Мін швидкість = " + stats1[0] + ", Макс швидкість = " + stats1[1]);
//        System.out.println("Мін швидкість = " + stats2[0] + ", Макс швидкість = " + stats2[1]);
//        System.out.println("Мін швидкість = " + stats3[0] + ", Макс швидкість = " + stats3[1]);
//    }
//
//    public static int[] getSpeedStatistic(int[] results) {
//
//        if (results == null || results.length == 0) {
//            return new int[]{0, 0};
//        }
//
//        int minSpeed = results[0];
//        int maxSpeed = results[0];
//
//        for (int speed : results) {
//            if (speed < minSpeed) {
//                minSpeed = speed;
//            }
//            if (speed > maxSpeed) {
//                maxSpeed = speed;
//            }
//        }
//        return new int[]{minSpeed, maxSpeed};
//    }


//    public static void main(String[] args) {
//        int[] speeds1 = new int[]{60, 70, 50, 80, 90};
//        int[] speeds2 = {100};
//        int[] speeds3 = {};
//
//        int[] stats1 = getSpeedStatistic(speeds1);
//        int[] stats2 = getSpeedStatistic(speeds2);
//        int[] stats3 = getSpeedStatistic(speeds3);
//    }
//
//    public static int[] getSpeedStatistic(int[] results) {
//
//        if (results.length == 0) {
//            return new int[2];
//        }
//
//        int min = results[0];
//        int max = results[0];
//        int[] response = new int[2];
//
//        for (int i: results) {
//            if (i > max) {
//                max = i;
//            }
//            if (i < min) {
//                min = i;
//            }
//        }
//        response [0] = min;
//        response[1] = max;
//        System.out.println("Мін швидкість = " + response[0] + ", Макс швидкість = " + response[1]);
//
//        return response;
//    }

























