package yugo;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MainString {

    public static void main(String[] args) throws InterruptedException {

//        String string = "word1 word2 word3 word4";
//        System.out.println("s3 = " + string);
//        String[] s1 = string.split(" ");
//        for (String s : s1) {
//            System.out.println("s = " + s);
//        }
//
//        String newS = "";
//        for (String s2 : s1) {
//            newS = newS.concat(" ");
//            newS = newS.concat(s2);
//        }
//        System.out.println("newS = " + newS);

//        Student student1 = new Student("Roman", "Romanov");
//        System.out.println("student1 = " + student1);
//        student1.setLastName("Romanov1");
//        Thread.sleep(10000);
//        Student student2 = new Student("Roman", "Romanov");
//        Student student3 = new Student("Roman", "Romanov");
//        Student student4 = new Student("Roman", "Romanov");

//        List<Integer> integers = new ArrayList<>();
//        for (int j = 0; j < 100; j++) {
//            long start = System.currentTimeMillis();
//            for (int i = 0; i < 1_000_000; i++) {
//                integers.add(i);
//            }
//            long end = System.currentTimeMillis() - start;
//            System.out.println("end = " + end);
//        }

//        String s = "Hello world"; // Строка - это массив чаров
//        System.out.println("s length = " + s.length());
//        char[] chars = s.toCharArray();   // метод toCharArray() переводит строку в массив чаров
//        for (char aChar : chars) {
//            System.out.println("aChar = " + aChar);
//        }
//        String pdfFile = "Some.PDF";
//        for (String fileType: new String[]{ "PDF", "TXT", "DOCX" }) {
////            if (pdfFile.toUpperCase().endsWith(fileType)) {     // переводим в верхний регистр и говорим на что заканчивается
//            if (pdfFile.toLowerCase().endsWith(fileType.toLowerCase())) {
//                System.out.println("file valid");
//            }
//        }
//
//        for (String fileType: new String[]{ "PDF", "TXT", "DOCX" }) {
//            if (StringUtils.endsWithIgnoreCase(pdfFile, fileType)) {  // библиотека апач игнорирует регистр
//                System.out.println("file valid");
//            }
//        }
//
//        String empty = "\n";
//        String blank = " \n";
//        if (!empty.isEmpty()) {       // стандартный Джавовый метод, идем от обратного, не красивый, не совсем понятный
//            System.out.println("not empty");
//        }
//        if (StringUtils.isNotEmpty(empty)) {  // апачевский метод (под капотом Джавовые стандартные методы)
//            System.out.println("not empty");
//        }
//        System.out.println("blank = " + blank.isBlank());
//
//        String capitalize = "test test";
//        capitalize = StringUtils.capitalize(capitalize);  // после точки, первую букву со всей строки делает заглавной
//        System.out.println("capitalize = " + capitalize);
//
//        String subs = "Hello world";
//        System.out.println("subs = " + subs);
//        subs = subs.substring(2, 7);          // вырезаем текст (от какого символа включительно и по какой исключительно)
//        System.out.println("subs = " + subs);
//
//        String url = "https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.12.0";
//        url = url.replace('2', '8');          // замена символов с 2 на 8
//        System.out.println("url = " + url);
//        url = url.replaceAll("https://", "www.");
//        System.out.println("url = " + url);
//
//        int i = url.indexOf('3');         // находим значение индекса конкретного первого числа, буквы, символа в строке
//        System.out.println("i = " + i);
//        i = url.lastIndexOf('/');         // находим значение индекса последнего последнего числа, буквы, символа в строке
//        System.out.println("i = " + i);
//        url = url.substring(0, i);        // вырезаем кусок строки по заданным параметрам
//        System.out.println("url = " + url);
//
//        String[] strings = url.split("/");    // создаем массив строк, которые получили, вырезав кусками по заданому символу
//        for (String string : strings) {
//            System.out.println("string = " + string);
//        }
//
//        String email = " user@gmail.com ";
//        System.out.println("email = " + email);
//        email = email.trim();                         // убирает все пробелы
//        System.out.println("email = " + email);
//
//        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
//        if (email.matches(emailRegex)) {                              // проверяет точное совпадение строки со стандартным шаблоном
//            System.out.println("email is valid");
//        } else {
//            System.out.println("email is nоt valid");
//        }

        String some = "v2as434fas234";
        String numberRegex = "[0-9]*$";     // проверяет является ли числом
        System.out.println("some is valid: " + some.matches(numberRegex));

        String number = some.replaceAll("[^0-9]", "");  // выкидываем буквы и оставляем только цифры
        System.out.println("number = " + number);


        char[] chars = number.toCharArray();
        System.out.println("chars = " + Arrays.toString(chars));

        int sum = 0;
        for (char aChar : chars) {
            String s = String.valueOf(aChar);   // если не переведем в строку, то получим значение чара согласно аски таблице
            // т.е наш первый чар - цифра 2 char c = '2';
            //int num = (int) c; интерпретируется как значение в аски таблице под номером "2", поэтому сначала чары нужно
            // перевести в строки, а потом уже в интеджеры
            int element = Integer.parseInt(s);  // Integer.parseInt(s) делает из строки целое число
            sum += element;
        }
        System.out.println("sum = " + sum);

        some = "v2as434fas234";
        numberRegex = "[^a-zA-Z]";
        String latins = some.replaceAll(numberRegex, "");
        System.out.println("latins = " + latins);

    }
}