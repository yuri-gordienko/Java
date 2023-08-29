package ua.com.alevel;

public class Сycles {

    public static void main(String[] args) {

        int age = 17;

        if (age >= 18) {
            System.out.println("you are adult person");
        } else {
            System.out.println("you are not adult person");
        }

        for (int i = 1; i < 10; i++){
            System.out.println(i);
        }   // for i

        int [] numbers = {10, 20, 30};
        for (int i : numbers) {
            System.out.println(i);
        }   // for-each

        int j = 0;
        while (j < 5){
            System.out.println(j);
            j++;
        }// while
    }
}
