package ua.com.alevel.Tasks;

public class Tasks {

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
//        У результаті виходить не значення, а чортзна-що
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

// У світі є багато речей, які складаються з кількох слів. Ми хочемо створити метод makeAbbr(),
// який буде повертати для них абревіатури.
//Наприклад:
//makeAbbr("national aeronautics space administration");
// "NASA"


//public class MakeAbbr {
//  public static String makeAbbr(String fullName) {
//    String[] s = fullName.split(" ");
//            StringBuilder sb = new StringBuilder();
//
//            for (String i: s) {
//                sb.append(i.toUpperCase().charAt(0));
//            }
//            return sb.toString();
//  }
//}
//----------------------------------------------------------------------------------------------------------

//У цьому завданні реалізуй метод getMiddleString(), що приймає рядок і повертає центральний символ у вигляді рядку.
//Зверни увагу: якщо довжина рядка парна, поверни два центральних символи.
//Наприклад:
//getMiddleString("hello"); // "l"
//getMiddleString("1234"); // "23"

//public class GetMiddleCharacter {
//  public static String getMiddleString(String originalString) {
//    int stringLength = originalString.length();
//
//    /*
//        for empty string input we can just return "", if we try access elements by index
//        we will get error - IndexOutOfBoundException
//     */
//    if (stringLength == 0) {
//      return "";
//    }
//
//    int middleIndex = stringLength / 2;
//
//    /*
//       if input length is odd we need to return 1 symbol, if even 2
//       - odd: return originalString.substring(middleIndex, middleIndex + 1);
//       - even: return originalString.substring(middleIndex - 1, middleIndex + 1);
//     */
//    return stringLength % 2 == 1 ? originalString.substring(middleIndex, middleIndex + 1)
//          : originalString.substring(middleIndex - 1, middleIndex + 1);
//  }
//}
//-------------------------------------------------------------------------------------------------------

//В цьому завданні реалізуй метод removeOddChars(), який приймає рядок і видаляє в ньому всі непарні символи,
// а потім повертає результат.
//Зверни увагу: непарні символи у рядку розташовані на непарних індексах.
//Наприклад:
//removeOddChars("hello"); // "hlo"
//// 'e' та 'l' було видалено,
//// бо вони знаходяться на індексах 1 і 3
//
//removeOddChars("1234"); // "13"


//my method
//public class RemoveOddChars {
//  public static String removeOddChars(String originalString) {
//     if (originalString == null && originalString.length() == 0){
//            return "";
//        }
//        StringBuilder sb = new StringBuilder();
//        char[] s = originalString.toCharArray();
//        for (char i =0; i < originalString.length(); i++) {
//            if (i % 2 == 0) {
////                System.out.println(s);
//                sb.append(s[i]);
//            }
//        }
//        System.out.println(sb);
//        return sb.toString();
//  }
//}

    //alternative
    //public class RemoveOddChars {
    //  public static String removeOddChars(String originalString) {
    //    StringBuilder builder = new StringBuilder();
    //    for (int i = 0; i < originalString.length(); i++) {
    //      if (i % 2 == 0) {
    //        builder.append(originalString.charAt(i));
    //      }
    //    }
    //    return builder.toString();
    //  }
    //}
//------------------------------------------------------------------------------------------------------

//Твоє завдання: реалізуй метод так, щоби він повертав масив типу String з двох елементів: originalString з першим символом у верхньому регістрі та originalString з останнім символом у верхньому регістрі.
//Наприклад:
//markStringEnds("hello"); // ["Hello", "hellO"]
//markStringEnds("example"); // ["Example", "examplE]

    //public class MarkStringEnds {
    //  public static String[] markStringEnds(String string) {
    //    if (string == null || string.isEmpty()) {
    //            return new String[]{string};
    //        }
    //        String s1 = string
    //                .substring(0, 1)
    //                .toUpperCase()
    //                + string.substring(1);
    //        String s2 = string
    //                .substring(0, string.length() - 1)
    //                + string.substring(string.length() - 1)
    //                .toUpperCase();
    ////        System.out.println(s1);
    ////        System.out.println(s2);
    //
    //        String[] s = new String[]{s1, s2};
    //        // System.out.println(Arrays.toString(s));
    //
    //        return s;
    //  }
    //}
    //---------------------------------------------------------------------------------------------------------

//Тепер ти створиш новий масив зі значеннями елементів, які націло діляться на вказане число.
//Ми оголосили метод getDivisibleNumbers(), який приймає два параметри: масив int[] numbers та дільник int divider.
//Твоє завдання: реалізуй метод так, щоби він повертав масив тільки з тими числами,
// які націло діляться на число divider та є додатними. Візьми до уваги, що порядок додатних чисел,
// які націло діляться на divider у поверненому масиві, має бути таким самим, як і у вихідному масиві.
//
//Наприклад, з такими вхідними даними:
//int[] numbers = {2, 5, 8, 0, 7, 1, -4};
//int divider = 2;
//Результат буде таким:
//int[] result = {2, 8};

    // public class DivisibleNumbers {
    //  public static int[] getDivisibleNumbers(int[] numbers, int divider) {
    //     int count = 0;
    //    for (int n : numbers) {
    //        if (n > 0 && n % divider == 0) {
    //            count++;
    //        }
    //    }
    //
    //    int[] result = new int[count];
    //    int index = 0;
    //    for (int n : numbers) {
    //        if (n > 0 && n % divider == 0) {
    //            result[index] = n;
    //            index++;
    //        }
    //    }
    //
    //    return result;
    //  }
    //}
    //----------------------------------------------------------------------------------------------------------





}
