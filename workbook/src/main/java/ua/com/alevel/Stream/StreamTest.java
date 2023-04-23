package ua.com.alevel.Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public void test() {
//        int[] ints = [0 ... 10];      // создание коллекции в Котлине и Скале (одинаковый синтаксис)
        int[] ints = new int[101];      // в Джаве создали массив интов императивно
        for (int i = 0; i < 101; i++) {
            ints[i] = i;
        }

        // Стрим дженерик - содержит объекты любых типов
        IntStream intStream = IntStream.range(0, 101);  // создали массив интов декларативно
        intStream.forEach(is -> System.out.println("is = " + is));  // в лямду попадает объкт is - intStream

        List<Integer> integers1 = Arrays.asList(1, 3, 6, 8,9);  // 1 способ создания Стрима - на базе Листа интеджеров
        Stream<Integer> integerStream1 = integers1.stream();    // на Листе вызываем Стрим (чаще всего используемый способ)

        Stream<Integer> integerStream2 = Stream.of(1, 3, 6, 8,9); // 2й на лету создаем Стрим (сразу создали объект типа Стрим)

        Stream<Integer> integerStream3 = Arrays.stream(new Integer[]{1, 3, 6, 8,9});    // 3й - на основе массива

        Stream<Integer> integerStream4 = Stream.<Integer>builder()  // 4й пошаговым добавлением объеков
                .add(1)
                .add(3)
                .add(6)
                .add(8)
                .add(9)
                .build();

        Stream<Integer> integerStream11 = Stream
                .generate(() -> new Random().nextInt(10, 1000)) // создали Стрим рандомных объектов
                .limit(1_000_000);  // лимит на вывод объектов
        Stream<Integer> integerStream22 = Stream
                .generate(() -> new Random().nextInt(10, 1000))
                .limit(1_000_000);

        // конвеерный оператор - принимает Стрим и возвращает Стрим
        // тернарный оператор - принимает Стрим, прерывает Стрим и возвращает объект
        long start = System.currentTimeMillis();
        List<Integer> integersFirst = integerStream11
                .filter(integer -> integer % 2 == 0)    //  оставили четные числа - конвеерный
                .sorted()   // сортируем по порядку (от меньшего к большему) - конвеерный оператор
                .distinct() // убрать дубликаты - конвеерный
                .toList();  // превращает в коллекцию - тернарный

        long end = System.currentTimeMillis() - start;  // замеряем время отработки
//        System.out.println("random end = " + end);

        start = System.currentTimeMillis(); // сравниваем скорость в зависимости от порядка вызова фильтров
        List<Integer> integersOptimal = integerStream22
                .distinct()
                .filter(integer -> integer % 2 == 0)
                .sorted()
//                .skip(100)    // пропусти первые 100
                .limit(10)  // выведи первые 10
                .toList();  // преврати в коллекцию

        end = System.currentTimeMillis() - start;
//        System.out.println("optimal end = " + end);


        // проверить, что в коллекции все числа четные (совпадает = четные)
        boolean isEven = integersOptimal.stream().allMatch(this::isEven);

        // проверить, что в коллекции все числа не четные (каждый элемент итерации не соответствует четным)
        isEven = integersOptimal.stream().noneMatch(this::isEven);

        // проверить, что в коллекции хоть одно число четное (хоть один элемент итерации = четным)
        isEven = integersOptimal.stream().anyMatch(this::isEven);


        System.out.println("isEven = " + isEven);

//        integersOptimal.forEach(integer -> System.out.println("integer = " + integer));


    }

    private boolean isEven(Integer integer) {   // тривиальный способ проверки на четные
        return integer % 2 == 0;
    }
}