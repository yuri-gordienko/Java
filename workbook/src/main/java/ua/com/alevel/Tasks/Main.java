package ua.com.alevel.Tasks;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

//        SpeedStatistic.getSpeedStatistic(new int[]{10, 10, 11, 9, 12, 8});

    }


}

//-------------------------------------------------------------------------------------------------------------
//    У цьому завданні ти навчишся ітерувати масив.
//        Реалізуй метод getDoublePower(), що приймає масив цілих чисел powers та повертає масив, у якому
//        кожне значення елементу помножене на 2.

//public class DoublePower {
//    public static int[] getDoublePower(int[] numbers) {
//        int[] numbers2 = new int [numbers.length];
//        for (int i = 0; i < numbers2.length; i++) {
//            numbers2[i] = numbers[i] * 2;
//            System.out.println(numbers2[i]);
//        }
//        System.out.println(numbers2);
//        return numbers2;
//    }
//}
//----------------------------------------------------------------------------------------------------------------

//    Твоє завдання: реалізуй метод getSum(), дотримуючись певних умов:
//
//        метод повинен повернути суму значень елементів, починаючи із середини масиву.
//        Для цього, при оголошенні циклу, замість int i = 0; підстав коректний вираз;
//        якщо зустрінеш число 1, вийди повністю з усього циклу за допомогою оператору break
//        (не додавай 1 до суми);
//        не використовуй оператор continue.

//public class LoopBreaker {
//    public static int getSum(int[] numbers) {
//        int sum = 0;
//        for (int i = numbers.length / 2; i < numbers.length; i++) {
//            if (numbers[i] == 1) {
//                break;
//            }
//            sum += numbers[i];
//
//        }
//        System.out.println(sum);
//        return sum;
//    }
//}
//-----------------------------------------------------------------------------------------------------------------

//    Твоє завдання: реалізуй метод getSpeedStatistic(), який приймає масив швидкостей results і повертає масив
//    зі статистикою, у якому:
//        перший елемент - найменша швидкість;
//        другий елемент - найбільша швидкість.
//        Зверни увагу:
//
//        якщо вхідний масив порожній, поверни масив зі статистикою {0, 0};
//        якщо вхідний масив складається лише з одного елемента, вважай його одночасно найменшою та найбільшою швидкістю.

//public class SpeedStatistic {
//    public static int[] getSpeedStatistic(int[] results) {
//        if (results == null || results.length == 0) {
//            return new int[]{0, 0};
//        }
//        if (results.length == 1){
//            return new int[]{results[0], results[0]};
//        }
//
//        int minSpeed = results[0];
//        int maxSpeed = results[0];
//
//        for (int speed : results) {
//            if (speed < minSpeed) {
//                minSpeed = speed;
//            }
//            if (speed > maxSpeed) {
//                maxSpeed = speed;
//            }
//        }
//
//        return new int[]{minSpeed, maxSpeed};
//
//    }
//}