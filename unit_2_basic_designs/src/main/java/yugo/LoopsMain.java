package yugo;

public class LoopsMain {

    public static void main(String[] args) {

//        int[] numbers = new int[]{getMaxNumber(new int[]{10, 5, 3, 24, 2})};
//        int[] numbers2 = new int[]{getSum(new int[]{3, 5, 0, 8, 7})};
        int[] numbers3 = new int[]{getSum2(new int[]{9, 9, 4, 2, 8, 1, 2})};
    }


    public static int getSumOfFirstTenNumbers() {
        int result = 0;

        for (int i = 0; i <10; i++ ) {
            result += i;
        }
        return result;
    }


    public static int getSum(int n, int step) {
        int result = 0;

        for (int i = 0; i <=n ; i +=step) {
            result += i;
        }
        return result;
    }


    public static int getSum(int n) {
        int result = 0;

        for (int i = n; i >= 0 ; i--) {
            result += i;
        }
        return result;
    }


    public static int getDrinks(int numberOfGuests) {
        int drinks = 0;
        for (int i = 1; i <= numberOfGuests; i++) {
            drinks += i;
        }
        return drinks;
    }


//    Молодята обирають число step, і тепер тост говорить не кожен гість, а тільки перший і кожен, хто приходить
//    через обрану кількість (step) гостей після попереднього тосту. При цьому, як і раніше, п'ють усі присутні.
    public static int getDrinksWithStep(int guestNumber, int step) {
        int drinks = 0;
        for (int i = 1; i <= guestNumber; i += step) {
            drinks += i;
        }
        return drinks;
    }


    public static int getMaxNumber(int[] numbers) {
//        int max = numbers[0];
//        for (int number : numbers) {
//            max = max < number ? number : max;
//        }
//        System.out.println(max);
//        return max;

        int max = 0;
        for (int number : numbers) {
            if (max < number) {
                max = number;
            }
//            System.out.println("max = " + max);
        }
        System.out.println("max = " + max);
        return max;
    }

    public static int getSum(int[] numbers2) {
//        int sum = 0;
//        for (int number : numbers2) {
//            if (number % 2 != 0) {
//                sum += number;
//            }
//        }
//        System.out.println(sum);
//        return sum;

        int sum = 0;
        for (int number : numbers2) {
            if (number % 2 == 0) {
                continue;
            }
            sum += number;
        }
        System.out.println(sum);
        return sum;
    }

    public static int getSum2(int[] numbers3) {
        int sum = 0;
        for (int i = numbers3.length / 2; i < numbers3.length; i++) {
            if (numbers3[i] == 1) {
                break;
            }
            sum += numbers3[i];
        }
        System.out.println(sum);
        return sum;
    }



//    Цикл while має наступний синтаксис:
//         while (умова_виконнаня_тіла) {
//        тіло_циклу;
//    }
//    тіло_циклу - код, що буде повторно виконуватися до того часу, поки умова_виконнаня_тіла не згенерує результат false

//    Цикл do while має наступний синтаксис:
//        do {
//        тіло_циклу;
//    } while (умова_виконнаня_тіла);

//    Він подібний до циклу while з тією лише різницею, що перевіряє умову після виконання тіла циклу.
//    Цикл починає виконання тіла без перевірки будь-яких умов.
//    Іншими словами, тіло циклу завжди виконається принаймні один раз.
//
//    Після виконання тіла умова перевіриться на true або false. Якщо вона дорівнює true, починається наступна
//    ітерація циклу, якщо false - цикл завершується.
//
//    Розглянемо приклад:
//
//    int i = 1;
//    do {
//        System.out.println(i + ": цикл продовжується");
//        i++;
//    } while(i <= 5);
//
//    У консолі отримаємо такий результат:
//
//      1: цикл продовжується
//      2: цикл продовжується
//      3: цикл продовжується
//      4: цикл продовжується
//      5: цикл продовжується
//
//    Для значення i = 8 отримаємо такий результат:
//
//      8: цикл продовжується
//
//    Тобто тіло циклу виконалось один раз, а потім перевірилася умова циклу. Умова не виконалася, і цикл завершився.

    public static int reviewCode(int maxAttempts) {
        int solutionAttempts = 0;
        do {
            solutionAttempts++;
        } while (solutionAttempts < maxAttempts);
        return solutionAttempts;
    }

//    Оператор break
//    Оператор break дозволяє перервати виконання циклу в будь-який зручний для тебе момент - раніше, ніж цикл мав би завершитися.
//
//    Приклад використання оператору break:
//
//    int a = 1;
//    int b = 5;
//
//    while(a <= 10){
//        System.out.println(a + ": цикл продовжується");
//        if (a == b) {
//            break;
//        }
//        a++;
//    }
//
//    У консолі ми отримаємо:
//      1: цикл продовжується
//      2: цикл продовжується
//      3: цикл продовжується
//      4: цикл продовжується
//      5: цикл продовжується


//    Оператор continue
//    Оператор continue дозволяє опустити ділянку коду та повернутися на початок циклу.
//
//    Приклад використання оператору continue:
//
//        for (int i = 1; i <= 10; i++){
//          if (i % 2 != 0) {
//            continue;
//          }
//        System.out.println(i + ": парне число");
//        }
//
//    У консолі ми отримаємо:
//      2: парне число
//      4: парне число
//      6: парне число
//      8: парне число
//      10: парне число
//
//    Зверни увагу:
//    Оператор continue завершує лише поточну ітерацію циклу. Цикл продовжиться з наступною ітерацією.
//    Оператор break використовується для повного виходу з циклу.

}
