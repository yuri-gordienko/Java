package ua.com.alevel;

public class MethodsBasics {

////    Sum, multiply, divide
//    public static void main(String[] args){
//
//        int a = 2;
//        int b = 5;
//
//        rectangleInfo(a, b);
//
//        count(2, 4, 3 );
//    }
//
//    public static void rectangleInfo(int a, int b){
//        int perimeter = a * 2 + b * 2;
//        int square = a * b;
//
//        System.out.println("perimeter = " + perimeter);
//        System.out.println("square = " + square);
//    }
//
//    public static void count(int a, int b, int c) {
//        int result = a + b + c;
//        System.out.println("sum = " + result);
//    }


////    Return
//    public static void main(String[] args){
//        String smallhouse = buildHouse(2, "red");
//        String bighouse = buildHouse(9, "blue");
//
//        System.out.println(smallhouse);
//        System.out.println(bighouse);
//    }
//
//    public static String buildHouse(int house, String color) {
//        return color + " " + house + "th house";
//    }


//    Boolean
      public static void main(String[] args){
          boolean result = isEven(9);
          System.out.println(result);
      }

      public static boolean isEven(int a){
          return a % 2 == 0;
      }
}
