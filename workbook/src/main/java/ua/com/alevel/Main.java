package ua.com.alevel;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] results = new int[]{10, 10, 11, 9, 12, 8};
        getSpeedStatistic(results);


    }

    public static int[] getSpeedStatistic(int[] results) {
        if (results.length == 0) {
            int [] nul = new int[]{0,0};
//            System.out.println(Arrays.toString(nul));
            return nul;
        }

        int max = results[0];
        int min = results[0];
        for (int i = 0; i < results.length; i++) {
            if (max < results[i]) {
                max = results[i];
            } else if (min > results[i]) {
                min = results[i];
            }
        }
        System.out.println(Arrays.toString(new int[]{min, max}));
        return new int[]{min, max};
    }


}


























