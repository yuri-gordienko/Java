package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;

public class TimeMillis {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        int count = 0;
        for (int j = 0; j < 20; j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1_000_000; i++) {
                integers.add(i);
            }
            count++;
            long end = System.currentTimeMillis() - start;
            System.out.println(count + " - " + end);
        }
    }
}
