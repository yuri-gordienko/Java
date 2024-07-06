package yugo.test_MateAcademy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        int[] results = getSpeedStatistic(new int[]{});
        String string = getMiddleString("12345");
    }


//    Твоє завдання: реалізуй метод getSpeedStatistic(), який приймає масив швидкостей results і повертає масив
//    зі статистикою, у якому:
//    перший елемент - найменша швидкість;
//    другий елемент - найбільша швидкість.
//      - Зверни увагу:
//      - якщо вхідний масив порожній, поверни масив зі статистикою {0, 0};
//      - якщо вхідний масив складається лише з одного елемента, вважай його одночасно найменшою та найбільшою швидкістю.
//    Наприклад:
//    getSpeedStatistic({}); // {0, 0}
//    getSpeedStatistic({10}); // {10, 10}
//    getSpeedStatistic({8, 9, 9, 9}); // {8, 9}
//    getSpeedStatistic({10, 10, 11, 9, 12, 8}); // {8, 12}
    public static int[] getSpeedStatistic(int[] results) {
        int minSpeed = 0;
        int maxSpeed = 0;

        if (results.length == 0) {  // if (results == null)
            System.out.println("new int[]{if empty} = " + Arrays.toString(new int[]{0, 0}));
            return new int[]{0, 0};
        }
        for (int result : results) {
            if (results.length == 1) {
                System.out.println("new int[]{if one element} = " + Arrays.toString(new int[]{result, result}));
                return new int[]{result, result};
            }
        }
        for (int result : results) {
            if (maxSpeed < result) {
                maxSpeed = result;
            } else {
                minSpeed = result;
            }
        }
        System.out.println("new int[]{minSpeed, maxSpeed}) = " + Arrays.toString(new int[]{minSpeed, maxSpeed}));
        return new int[]{minSpeed, maxSpeed};
    }

    public static int[] getSpeedStatistic_2(int[] results) {
        if (results.length == 0) {
            return new int[]{0, 0};
        }

        int min = results[0];
        int max = results[0];

        for (int current : results) {
            if (current < min) {
                min = current;
            }

            if (current > max) {
                max = current;
            }
        }

        return new int[]{min, max};
    }


//    У цьому завданні реалізуй метод getMiddleString(), що приймає рядок і повертає центральний символ у вигляді рядку.
//    Зверни увагу: якщо довжина рядка парна, поверни два центральних символи.
//    getMiddleString("hello"); // "l"
//    getMiddleString("1234"); // "23"
//    getMiddleString("(())"); // "()"
//    getMiddleString("Bob"); // "o"
//    getMiddleString(""); // ""
    public static String getMiddleString(String originalString) {

        String midSimb = "";
        if (originalString.length() % 2 == 0) {
            midSimb = originalString.substring(originalString.length() / 2 - 1, originalString.length() / 2 + 1);
        } else {
            midSimb = originalString.substring(originalString.length() / 2, originalString.length() / 2 + 1);
        }

        System.out.println("midSimb is " + midSimb);
        return midSimb;
    }

    public static String getMiddleString_2(String originalString) {

        int stringLength = originalString.length();
        if (stringLength == 0) {
            return "";
        }

        int middleIndex = stringLength / 2;

        return stringLength % 2 == 1 ?
                originalString.substring(middleIndex, middleIndex + 1) :
                originalString.substring(middleIndex - 1, middleIndex + 1);
    }




}