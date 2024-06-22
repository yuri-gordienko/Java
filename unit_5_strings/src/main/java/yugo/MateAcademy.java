package yugo;

import java.util.Arrays;

public class MateAcademy {

    public static void main(String[] args) {

        String string = makeAbbr("national aeronautics space administration");
    }


//    Ми під'єднали базу даних і отримуємо з неї інформацію в наступному вигляді: data=value.
//    Але, останнім часом, у значенні value літери стоять то в верхньому, то в нижньому регістрі...
//    У результаті виходить не значення, а чортзна-що
//    Ми створили метод getValue(), який приймає рядок dataFromDatabase у вигляді data=value.
//    Твоє завдання: прибрати з рядку data та =, а потім повернути value у нижньому регістрі. Будь уважним,
//    бо value в собі теж може містити символ =.
//      for example: getValue("name=joHN"); // "john"
    public static String getValue(String dataFromDatabase) {
        int index = dataFromDatabase.indexOf("=");
        return dataFromDatabase.substring(index + 1).toLowerCase();
    }


//    У цьому завданні ми додали до вхідного рядка input привітання "Hello, " і хотіли повернути новий рядок.
//    Але код не спрацював.
public static String createGreeting(String input) {
    StringBuilder builder = new StringBuilder("Hello, ");
    builder.append(input);
    return builder.toString();
}


//    У методі combineStrings() з'єднай вхідні рядки one і two. В результаті поверни новий рядок.
//    Для з`єднання рядків використай клас StringBuilder
public static String combineStrings(String one, String two) {
    StringBuilder builder = new StringBuilder();
    builder.append(one).append(two);
    return builder.toString();
}


//    Є вхідний рядок input. З'єднай елементи під індексами 1 та 3 в новий рядок, а потім поверни його.
public static String createNewString(String input) {
    StringBuilder builder = new StringBuilder();
    builder.append(input.charAt(1));
    builder.append(input.charAt(3));
    return builder.toString();
}


//    Реверсни вхідний рядок input та поверни його з методу reverseString().
//    Наприклад:
//    String input = "Hello, world!"; // => "!dlrow ,olleH"
public static String reverseString(String input) {
    StringBuilder builder = new StringBuilder(input);
    return builder.reverse().toString();
}

//    Їх можна вважати перевертнями, якщо їх можна прочитати однаково зліва направо, та навпаки.
//    Реалізуй метод isWerewolf(), який покаже, чи є рядок target перевертнем.
//    isWerewolf("rotator"); // true ("rotator" -> "rotator")
//    isWerewolf("racecar"); // true ("racecar" -> "racecar")
//    isWerewolf("home"); // false ("home" -> "emoh")
//    isWerewolf("evacaniseebeesinacave"); // true ("evacaniseebeesinacave" -> "evacaniseebeesinacave")
//    isWerewolf("rOtaTor"); // false ("rOtaTor" -> "roTatOr")
    public static boolean isWerewolf(String target) {
        if (target.isEmpty()) {
            return true;
        }
        StringBuilder builder = new StringBuilder(target);
        return target.equals(builder.reverse().toString());
    }

    public static boolean isWerewolf2(String target) {
        int length = target.length();
        for (int i = 0; i < target.length() / 2; i++) {
            if (target.charAt(i) != target.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }


//  makeAbbr("national aeronautics space administration"); "NASA"
public static String makeAbbr(String fullName) {
    String[] str = fullName.split(" ");
//        System.out.println(Arrays.toString(str));

    StringBuilder builder = new StringBuilder();
    for (String string : str) {
        String mmm = String.valueOf(string.toUpperCase().charAt(0));
//            System.out.println(mmm);
        builder.append(mmm);
    }
    System.out.println(builder);
    return builder.toString();
}

    public static String makeAbbr2(String fullName) {
        String[] nameParts = fullName.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String part : nameParts) {
            stringBuilder.append(part.charAt(0));
        }
        return stringBuilder.toString().toUpperCase();
    }


//    Твоє завдання: перевір, скільки пачок тіста ми купили. Поверни true, якщо ми купили 2 або більше пачки,
//    або false, якщо менше. Зверни увагу: dough - це один з елементів масиву ingredients, а тобі треба порахувати,
//    скільки таких елементів містить масив.
public static boolean doughIsEnough(String[] ingredients) {
    int doughCounter = 0;
    for (String ingredient : ingredients) {
        if (ingredient.equals("dough")) {
            doughCounter++;
        }
    }
    return doughCounter >= 2;
}


//    Після збору статистики вона відправляє дані на сервер у вигляді рядку 111001010111011, де 1 - це студент,
//    що зрозумів тему, а 0 - відповідно, ні.
//    Але було б корисно зрозуміти, яка частка студентів, що засвоїли матеріал, тобто, наскільки вебінар був ефективний.
//    Задання: реалізуй метод getSuccessRate(), який приймає рядок statistic та повертає частку студентів,
//    які зрозуміли матеріал, у вигляді змінної типу double.
public static double getSuccessRate(String statistic) {
    if (statistic.isBlank()) {
        return 0.0;
    }
    int count = 0;
    char[] stat = statistic.toCharArray();
    for (int i = 0; i < stat.length; i++) {
//        System.out.println(stat[i]);
        if (stat[i] == '1')
            count++;
    }
    return (double) count / statistic.length();
}

    public static double getSuccessRate2(String statistic) {
        if (statistic.isEmpty()) {
            return 0;
        }
        int successCounter = 0;
        for (char character : statistic.toCharArray()) {
            if (character == '1') {
                successCounter++;
            }
        }
        return (double) successCounter / statistic.length();
    }


//    Arrays.toString()
//    Метод Arrays.toString() використовується для перетворення масиву в рядок, де кожен елемент масиву
//    розділяється комою, наприклад:
//    String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//    String result = Arrays.toString(daysOfWeek);
//    System.out.println(result); // "[Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]"



//    Реалізуй метод compareStrings(), який приймає рядки firstString і secondString та повертає true,
//    якщо вони однакові, або false, якщо ні.
//    Зверни увагу: якщо обидва рядки мають значення null, вони також вважаються однаковими.
public static boolean compareStrings(String firstString, String secondString) {
    if (firstString == null && secondString == null) {
        return true;
    }
    return firstString != null && firstString.equals(secondString);
}
}
