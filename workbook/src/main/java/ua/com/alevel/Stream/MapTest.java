package ua.com.alevel.Stream;

import java.util.Arrays;
import java.util.List;

public class MapTest {

    public void test() {
        List<String> stringList = Arrays.asList("1", "2", "te", "4", "9", "ihi");   // Массив строк

        // Задача - вычленить из массива все числа, превратить числа в Интеджеры, найти их сумму
        int sum = stringList    // 1й способ суммировать. На Листе вызываем Стрим
                .stream()   // вызываем Стрим
                .filter(el -> el.matches("[0-9]"))  // оставляем только числа
                .map(el -> Integer.parseInt(el))    // принимает строку, переводит в число (Интеджеры - объекты) - тернарный оператор
                // т.е. с UI приняли строки и переводим их в Интеджеры для БД
//                .mapToInt((Integer value) -> {
//                    return value;            // простой способ (под капотом у лямбды)
//                    })
                .mapToInt(value -> value)   //  новый способ через лямбду, перевели в ИнтСтрим для улучшения работы с примитивами
                .sum(); // вызыаем сумму, тернарный оператор

        System.out.println("sum = " + sum);

        sum = stringList
                .stream()
                .filter(el -> el.matches("[0-9]"))
                .map(el -> Integer.parseInt(el))
                .reduce(0, (a, b) -> a + b);    // работает с парой, суммирует два соседних числа (0 - нужно сказать откуда начинать)

        System.out.println("sum = " + sum);
    }
}