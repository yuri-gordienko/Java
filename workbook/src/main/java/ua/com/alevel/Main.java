package ua.com.alevel;

public class Main {

    public static void main(String[] args) {

        calculateTaxes(10000);

    }

    public static double calculateTaxes(double income) {
        double tax = 0;
        if (income <= 1000){
            tax = income * 0.02;
        } else if (income > 1000 && income <= 10000) {
            tax = income * 0.03;
        } else if (income > 10000) {
            tax = income * 0.05;
        }
        System.out.println(tax);
        return tax;
    }


}



























