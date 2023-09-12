package ua.com.alevel;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        GetAverageSalary.getAverageSalary(new double[] {1000.00, 500.00}); // 750.00
        GetAverageSalary.getAverageSalary(new double[] {100.00, 200.00, 300.00}); // 200.00
        GetAverageSalary.getAverageSalary(new double[0]); // 0.00



    }

    public class GetAverageSalary {
        public static double getAverageSalary(double[] salaries) {
            // write your code below this line
            double count = 0.0;
            double count2 = salaries.length / 2;

            for (double s = 0; s <= salaries.length; s++){
                System.out.println(s);
                count += s;


            }
            System.out.println(count);
            return count2;
            // write your code above this line
        }
    }



}


























