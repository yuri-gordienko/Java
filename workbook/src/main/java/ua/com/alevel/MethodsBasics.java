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
//----------------------------------------------------------------------------------------

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
//---------------------------------------------------------------------------------------------------------

//    Boolean
      public static void main(String[] args){
          boolean result = isEven(9);
          System.out.println(result);
      }

      public static boolean isEven(int a){
          return a % 2 == 0;
      }
}


//    Приклад рекурсії
//    Додавання двох чисел легко зробити, але додавання діапазону чисел складніше. У наступному прикладі рекурсія
//    використовується для додавання діапазону чисел шляхом розбиття її на просте завдання додавання двох чисел:
//
//        прикладОтримайте власний сервер Java
//        Використовуйте рекурсію, щоб додати всі числа до 10.
//
//public class Main {
//    public static void main(String[] args) {
//        int result = sum(10);
//        System.out.println(result);
//    } } } }
//public static int sum(int k) {
//        if (k > 0) {
//        return k + sum(k - 1);
//        } else {
//        return 0;
//
//
//
//        Пояснення прикладу
//        Під час sum()виклику функції вона додає параметр kдо суми всіх чисел, менших за k, і повертає результат.
//        Коли k стає 0, функція просто повертає 0. Під час роботи програма виконує такі дії:
//
//        10 + сума (9)
//        10 + ( 9 + сума (8) )
//        10 + ( 9 + ( 8 + сума (7) ) )
//        ...
//        10 + (9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + сума (0))
//        10 + (9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + 0)
//        Оскільки функція не викликає сама себе, коли kдорівнює 0, програма зупиняється на цьому та повертає результат.


//    Стан зупинки
//    Подібно до того, як цикли можуть зіткнутися з проблемою нескінченного циклу, рекурсивні функції можуть зіткнутися
//    з проблемою нескінченної рекурсії. Нескінченна рекурсія — це коли функція ніколи не припиняє викликати саму себе.
//    Кожна рекурсивна функція повинна мати умову зупинки, яка є умовою, коли функція припиняє викликати саму себе.
//    У попередньому прикладі умова зупинки – це коли параметр kстає рівним 0.
//
//        Корисно побачити різноманітні приклади, щоб краще зрозуміти концепцію. У цьому прикладі функція додає
//        діапазон чисел між початком і кінцем. Умова зупинки для цієї рекурсивної функції полягає в тому, що end не
//        перевищує start :
//
//        приклад
//        Використовуйте рекурсію, щоб додати всі числа від 5 до 10.
//
//public class Main {
//    public static void main(String[] args) {
//        int result = sum(5, 10);
//        System.out.println(result);
//    }
//    public static int sum(int start, int end) {
//        if (end > start) {
//            return end + sum(start, end - 1);
//        } else {
//            return end;
//        }
//    }
//}
//        Метод sum отримує два параметри, start і end.
//
//        У першому рядку методу перевіряється, чи end більший за start. Якщо це так, то виконується наступний крок. В іншому випадку, повертається end.
//
//        Якщо end більший за start, то виконується наступне:
//
//        end додається до виклику sum з параметрами (start, end - 1). Цей виклик методу рекурсивно обчислює суму чисел від start до end - 1.
//        Цей процес триває, доки end не стане рівним start. Кожен раз, коли виконується рекурсивний виклик, до end додається число, менше на одиницю.
//        10 + (14 + 22 + 29 + 6 + сума (0))