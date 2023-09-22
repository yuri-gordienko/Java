package ua.com.alevel.Tasks;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){

//        String[] res = new String[]{"dough", "cheese", "sauce", "dough"};
//        CombineStrings.doughIsEnough(res);

        String s = String.valueOf(CombineStrings.getValue("national aeronautics space administration"));
        System.out.println(s);

    }

    public class CombineStrings {
        public static String getValue(String dataFromDatabase) {
//            System.out.println(dataFromDatabase);
            String[] s = dataFromDatabase.split(" ");
            StringBuilder sb = new StringBuilder();

            for (String i: s) {
                sb.append(i.toUpperCase().charAt(0));
            }
            return sb.toString();
        }
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
//---------------------------------------------------------------------------------------------------------------

//    Нещодавно ми під'єднали базу даних і отримуємо з неї інформацію в наступному вигляді: data=value.
//
//        Але, останнім часом, у значенні value літери стоять то в верхньому, то в нижньому регістрі...
//        У результаті виходить не значення, а чортзна-що 🤔
//
//        Ми створили метод getValue(), який приймає рядок dataFromDatabase у вигляді data=value.
//
//        Твоє завдання: прибрати з рядку data та =, а потім повернути value у нижньому регістрі.
//        Будь уважним, бо value в собі теж може містити символ =.

//public class CombineStrings {
//    public static String getValue(String dataFromDatabase) {
//        System.out.println(dataFromDatabase);
//        int i = dataFromDatabase.indexOf("=");
//        String s1 = dataFromDatabase.substring(i+1).toLowerCase();
//
//        System.out.println(s1);
//        return s1;
//    }
//}
//-----------------------------------------------------------------------------------------------------------

//    До нас дійшла інформація, що перевертні можуть бути небезпечними для людей.
//    Ми ще не знаємо чому, але ігнорувати цю інформацію ніяк не можна. Треба якомога швидше шукати перевертнів.
//
//        Пропонуємо для початку перевірити слова та речення. Їх можна вважати перевертнями,
//        якщо їх можна прочитати однаково зліва направо, та навпаки.
//
//        Реалізуй метод isWerewolf(), який покаже, чи є рядок target перевертнем.

//public class DetectWerewolf {
//    public static boolean isWerewolf(String target) {
//        StringBuilder sb = new StringBuilder(target);
//        sb.reverse();
//        String s2 = sb.toString();
//        System.out.println(s2);
//        return s2.equals(target);
//    }
//}
//-------------------------------------------------------------------------------------------------------

