package yugo.test_NIX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class NIX_testMain {

    public static void main(String[] args) {

//        try {
//            // Код, который может вызвать исключение
//            int result = 10 / 0; // Генерируется ArithmeticException
//        } finally {
//            // Код, который будет выполнен всегда
//            System.out.println("Блок finally выполнен.");
//        }

//        Vector<String> vector = new Vector<>();
//
//        // Добавление элементов
//        vector.add("Первый");
//        vector.add("Второй");
//        vector.add("Третий");
//
//        // Получение элементов
//        for (String element : vector) {
//            System.out.println(element);
//        }

//        ArrayList<Integer> numbers = new ArrayList<>();
//        numbers.add(5);
//        numbers.add(2);
//        numbers.add(8);
//        numbers.add(1);
//
//        Collections.sort(numbers); // Сортировка в порядке возрастания
//        System.out.println(numbers); // Вывод отсортированного списка

//        int x = 0, y = 10;
//        try {
//            y /= x;
//        }
//        System.out.println("/ 0");
//        catch (Exception e) {
//            System.out.println("error");
//        }

//        int a[][] = new int[3][];
//        a[1] = new int[] {1,2,3};
//        a[2] = new int[] {4,5};
//        System.out.println(a[1][1]);

//        boolean a = true;
//        boolean b = false;
//        boolean c = false;
//
//        boolean r1 = a || b && c;
//        boolean r2 = b || c && a || c;
//
//        System.out.println(r1);
//        System.out.println(r2);

//        String s = "Java";
//        s.concat(" SE 6");
//        s.replace('6', '7');
//        System.out.print(s);

//        try {
//            return;
//        } finally {
//            System.out.println("Finally");
//        }

//        try {
//            int x = 0;
//            int y = 5 / x;
//        } catch (Exception e) {
//            System.out.println("Exception");
//        } catch (ArithmeticException ae) {
//            System.out.println("AE");
//        }
//        System.out.println("finished");


// 1----------------------------------------------------------------
        Person p1 = new Person("Jon", 22);
        System.out.println("Person p1 = " + p1);
        NIX_testMain main = new NIX_testMain();
        System.out.println("main = " + main);
        Person p2 = main.change(p1);
        System.out.println("p2.main.change(p1) = " + p2);

        System.out.println(p2.pid + " " + p2.name + " " + p2.age);
        System.out.println(p1.pid + " " + p1.name + " " + p1.age);

// 2--------------------------------------------
//        try {
//            System.out.println("hello");
//            throwIt();
//        } catch (Exception re) {
//            System.out.println("caught");
//        } finally {
//            System.out.println("finaly");
//        }
//        System.out.println("after");

//
//  -----------------------------------------

//        try {
//            return 1;
//        } finally {
//            return 2;
//        }
//        ---------------------------

//        3
//        try {
//            bm();
//            System.out.println("A");
//        } catch (Exception ex) {
//            System.out.println("B");
//        } finally {
//            System.out.println("finally block: C");
//        }
//        System.out.println("D");
//        -------------------------------------

//        4
//        try {
//            bm();
//            System.out.println("A");
//        } catch (RuntimeException ex) {
//            System.out.println("B");
//        } catch (Exception ex1) {
//            System.out.println("C");
//        } finally {
//            System.out.println("D");
//        }
//        System.out.println("E");
//---------------------------------------
//       5
//        new NIX_testMain().print();
//-----------------------------------------

//        int i = 10;
//        int n = i++ % 5;
//        System.out.println(i + " " + n);

//        int i = 10;
//        int n = ++i % 5;
//        System.out.println(i + " " + n);


//        int[] a = {1,2,3,4,5,6};
//        int i = a.length -1;
//        while (i >0) {
//            System.out.println(a[i]);
//            i--;
//        }

//        int[]a = {1,2,3,4};
//        System.out.println(a instanceof Object);

//        -------------------
//        6
//        int x = 10;
//        int y = new NIX_testMain().change(x);
//        System.out.println(x + y);

    }

//....................................................................................................


//    1
    private Person change(Object o) {
        Person p2 = (Person) o;
        p2.age = 25;
        return p2;
    }

    static class Person{
        static int pid;
        int age;
        String name;

        Person (String s, int i) {
            ++ pid;
            name = s;
            age = i;
        }
    }
//    ---------------------------------------------------------

//    2
//    public static void throwIt() {
//        System.out.println("throwIt");
//        throw new RuntimeException();
//    }
//    -----------------------------------------

//    3
//    public static void bm() {
//        throw new Error();
//    }
//    -----------------------------------

//    4
//        public static void bm() {
//        throw new RuntimeException();
//        }
//    ----------------------------------------------

//    5
//    int a = 10;
//
//    public void print() {
//        int a = 8;
//        System.out.println(a);
//    }
//    ----------------------

//     6
//    int change(int x) {
//        x = 12;
//        return x;
//    }

}
