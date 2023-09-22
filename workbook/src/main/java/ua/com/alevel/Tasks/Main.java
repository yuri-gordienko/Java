package ua.com.alevel.Tasks;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

//        String s = String.valueOf(CombineStrings.getValue("national aeronautics space administration"));
//        String[] s = example("examply");
//        getOccurrenceCount(new String[] {"blue", "blue", "red"}, null);
//        getAverageSalary(new double[] {100.00, 200.00, 300.00});
//        System.out.println("-" + s);
        getDivisibleNumbers(new int[] {2, 5, 8, 0, 7, 1, -4}, 2); // [40, 10]

    }

    public static int[] getDivisibleNumbers(int[] numbers, int divider) {
//        System.out.println(Arrays.toString(numbers));
//        System.out.println(divider);
        int count = 0;
        for (int n : numbers){
            if (n % divider == 0 && n > 0) {
                count++;
//                System.out.println(count);
//                System.out.println(n);
//                System.out.println(new int[count] = n);
//                System.out.println(Arrays.toString(n2));

            } else {
                int[] n2 = new int[count];
                n2[count] = n;
                count++;
                System.out.println(Arrays.toString(n2));
            }

        }

        return new int[0];
    }



}


