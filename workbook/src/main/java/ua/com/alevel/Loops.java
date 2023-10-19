package ua.com.alevel;

public class Loops {

    public static void main(String[] args) {

//        for, while
//
//        Оператор += - это сокращенная форма для сложения значения одной переменной с другой переменной
//        и присвоения результата выбранной переменной.
//        int sum = 0;        // складываем каждый шаг итерации согласно его значения со всеми предыдущими
//        int guests = 5;
//            for (int i = 1; i <= guests; i++) {
//                System.out.println("i " + i);
//                sum += i;
//                System.out.println("sum " + sum);
//            }   // for i

//        int sum = 0;        // складываем каждый шаг итерации согласно его значения со всеми предыдущими
//        int guests = 10;
//        int step = 3;
//            for (int i = 1; i <= guests; i = i + step) {
//                System.out.println("i " + i);
//                sum += i;
//                System.out.println("sum " + sum);
//            }   // for i

//            for (int i = 10; i > 1; i--) {
//                System.out.println(i);
//            }   // for i

//
//            int[] numbers = {10, 20, 30};
//            for (int i : numbers) {
//                System.out.println(i);
//            }   // for-each
//
//        }

//            Четные/ не четные
//            for (int i=0; i<10; i++) {
//                if (i % 2 !=0) {
//                    continue;
////                    break;
//                }
//                System.out.println(i);
//            }

//        for (int i = 0; i < 10; i++) {
//            if (i == 4) {
//                System.out.println("done " + 4);
//                continue;
//            }
//            System.out.println(i);
//        }

//        ___________________________________________________________________________________________________
//        int j = 0;
//        while (j < 5) {
//           System.out.println(j);
//           j++;
//        }// while


//        double i = 1200;
//        int count = 0;
//
//        while (i % 2 == 0) {
//            i = i / 4;
//            System.out.println(i);
//            count++;
//        }
//        System.out.println(count);


//        Цикл Do/While
//        Петля do/whileє різновидом петлі while. Цей цикл виконає блок коду один раз, перш ніж перевірити, чи виконується умова, а потім повторюватиме цикл, доки умова виконується.
//
//        Синтаксис
//        do {
//            // code block to be executed
//        }
//        while (condition);
        // Принудительное выполнение программы, хотябы 1 раз

//        double i = 120;
//        int count = 0;
//
//        do {
//            i = i / 2;
//            System.out.println(i);
//            count++;
//        } while (i % 2 == 0);
//        System.out.println(count);


        // Бесконечный цикл
//        int i = 0;
//        while (true) {
//            i++;
//            System.out.println(i);
//
//            if (i == 1000) {
//                break;  //  Принудительная остановка
//            }
//        }
    }
}

