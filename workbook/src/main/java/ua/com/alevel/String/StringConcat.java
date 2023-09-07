package ua.com.alevel.String;

import java.util.Arrays;

public class StringConcat {

    public static void main(String[] args) {

        // метод concatenation занимает много места в памяти, т.к. постоянно перезаписывает строку через каждых 2 объекта
        // но его быстрее написать, подходит для небольшого кол-ва инфо
        String concatenation = "Hello " + "world " + 15 + " " + true + " " + 2.14;
        System.out.println(concatenation);

        // StringBuilder более долго писать, но занимает меньше места в памяти, добавляя объекты по одному
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ")
                .append("world ")
                .append(15)
                .append(" ")
                .append(true)
                .append(" ")
                .append(2.14);
        System.out.println(sb);

        System.out.println("REVERSE-----------------------------------------------------------------------");

        System.out.println(sb.reverse());

        StringBuilder newRev = sb.reverse();
        String newRewToStr = newRev.toString();
        System.out.println(newRewToStr);

        System.out.println("------------------------------------------------------------------------");

        StringBuilder sitcom = new StringBuilder("Big Bang Theory");
        sitcom.append(", ").append("Friends");
        String sitcoms = sitcom.toString();
        System.out.println(sitcoms);

        System.out.println("------------------------------------------------------------------------");

        String fruits = "apple banana";
        String[] fruit = fruits.split(" ");
        String result = Arrays.toString(fruit);
        System.out.println(result);

        System.out.println("------------------------------------------------------------------------");

        // Є вхідний рядок input. З'єднай елементи під індексами 1 та 3 в новий рядок, а потім поверни його.
//        public class CreateNewString {
//            public static String createNewString(String input) {
//                StringBuilder builder = new StringBuilder();
//                builder.append(input.charAt(1));
//                builder.append(input.charAt(3));
//                return builder.toString();
//            }
//            // or
//            public class CreateNewString {
//                public static String createNewString(String input) {
//                    return input.charAt(1) + "" + input.charAt(3);

//        String str = "Hello";
//        char firstChar = str.charAt(0); // Отримуємо перший символ 'H'
//        char thirdChar = str.charAt(2); // Отримуємо третій символ 'l'
//                }
//            }
//
//        }

    }
}
