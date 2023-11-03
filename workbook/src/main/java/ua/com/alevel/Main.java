package ua.com.alevel;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        string("123456", "123456");
//        String[] ingredients = {"dough", "cheese", "sauce", "dough"};
//        doughIsEnough(ingredients);
//        String input = "Hello, world!";
//        string(input);



    }

//    public static String string(String input) {
        public static boolean string(String firstString, String secondString) {
            if (firstString == null && secondString == null){
                return true;
            }
            if (firstString.equals(secondString)){
                return true;
            }
            return false;
        }
//    }




}


























