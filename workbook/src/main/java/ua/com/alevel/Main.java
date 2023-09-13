package ua.com.alevel;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        CountTheMonkeys.countTheMonkeys(5);
//        int[] numbers;
            String[] firstArray = ConvertBooleans.getStringArray(new boolean[]{true, false});
//        int[] secondArray = {3, 5};
//        DivisibleNumbers.getDivisibleNumbers(new int[]{2, 5, 8, 0, 7, 1, -4}, 2);
//        System.out.println("start = " + Arrays.toString(number));



    }

    public class ConvertBooleans {
        public static String[] getStringArray(boolean[] values) {
            System.out.println("start = " + Arrays.toString(values));

            String[] res = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                if (values[i]){
                    res[i] ="Yes";
                } else {
                    res[i] ="No";
                }
            }
            System.out.println(Arrays.toString(res));
            return res;
}





    }


}


























