package ua.com.alevel.String;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringMain {

        public static void main(String[] args) throws InterruptedException {

            String s3 = "fdsfsf fsdfsdf fsdfsdfs fsdfsdf";  // разбить и объединить строки
            System.out.println("s3 = " + s3);
            String[] s1 = s3.split(" ");    // разбили строку на подстроки по пробелам
            String newS = "";
            for (String s2 : s1) {
                newS = newS.concat(" ");    // объединили разбитые строки по пробелам
                newS = newS.concat(s2);
            }


        List<Integer> integers = new ArrayList<>(); // считаем время холодного запуска (JIT)
        for (int j = 0; j < 100; j++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1_000_000; i++) {
                integers.add(i);
            }
            long end = System.currentTimeMillis() - start;
            System.out.println("end = " + end);
        }


        String s = "Hello world";   // перевод строки в чары
        System.out.println("s length = " + s.length());
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            System.out.println("aChar = " + aChar);
        }


        String pdfFile = "Some.PDF";    // прилетел файлик, но расширение может быть указано не известно в каком регистре
        for (String fileType: new String[]{ "PDF", "TXT", "DOCX" }) { // джавовый метод сравнения (определения расширения)
//            if (pdfFile.toUpperCase().endsWith(fileType)) {   // перевод текста после точки в верхний регистр
//            if (pdfFile.toUpperCase().startWith(fileType)) {   // перевод текста перед точкой в верхний регистр
            if (pdfFile.toLowerCase().endsWith(fileType.toLowerCase())) {   // перевод текста после точки в нижний регистр
                System.out.println("file valid");
            }
        }

        // апачевский метод, более правильный, чтоб не угадывать регистр
        for (String fileType: new String[]{ "PDF", "TXT", "DOCX" }) {
            // говорим что хотим сравнить и сравниваем с типом расширения файла
            if (StringUtils.endsWithIgnoreCase(pdfFile, fileType)) {
                System.out.println("file valid");
            }
        }


        String empty = "\n";    // пустая ли строка (учитывает спец.символы, например пробелы, переход на новую строку)
        String blank = " \n";   // // пустая ли строка (не учитывает спец.символы)
        if (!empty.isEmpty()) { // не пустая ли строка
            System.out.println("not empty");
        }
        if (StringUtils.isNotEmpty(empty)) { // не пустая ли строка (более красивый способ)
            System.out.println("not empty");
        }
        System.out.println("blank = " + blank.isBlank());



        String capitalize = "test test";    // переводит первую букву в верхний регистр
        capitalize = StringUtils.capitalize(capitalize);
        System.out.println("capitalize = " + capitalize);

        String subs = "Hello world";    // обрезка текста
        System.out.println("subs = " + subs);
        subs = subs.substring(2); // выводит текст, начиная со 2го симвора (обрезает первый 2)
        subs = subs.substring(2, 7);    // выводит со второго по седьмой
        System.out.println("subs = " + subs);

        String url = "https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.12.0";  // замена символов
        url = url.replace('2', '8');    // заменить 2ки на 8ки
        System.out.println("url = " + url);
        url = url.replaceAll("https://", "www.");   // замена url адреса
        System.out.println("url = " + url);

        int i = url.indexOf('3');   // выводит порядковый номер символа "3" в строке (первый, который встретиться)
        System.out.println("i = " + i);
        i = url.lastIndexOf('/');   // выводит порядковый номер символа "3" в строке (который встретиться после /)
        System.out.println("i = " + i);
        url = url.substring(0, i);  // обрезка строки от 0 индекса до порядкового номера символа, который мы указали url.indexOf('3')
        System.out.println("url = " + url);

        String[] strings = url.split("/");  // разбить строку на подстроки по слешам /
        for (String string : strings) {
            System.out.println("string = " + string);
        }

        String email = " user@gmail.com ";
        System.out.println("email = " + email);
        email = email.trim();                       // убрать пробелы
        System.out.println("email = " + email);

        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";    // регулярное выражение,
        // начинается с символов, потом слеши, потом @, потом символы, потом слеши, после точки от 2 до 4 символов должно быть
        if (email.matches(emailRegex)) { // проверяет валидный ли email (проверяет на присутствие в строке букв и символов, @)
            System.out.println("email is valid");
        } else {
            System.out.println("email is not valid");
        }

            String some = "v2as434fas234";
            String numberRegex = "[0-9]*$"; //  проверка на содержание в строке только цифр (булевое значение)
            System.out.println("some is valid: " + some.matches(numberRegex));

            // выбирает в строке цифры от 0 до 9, потом заменяет их на пробелы (оставляем только числа)
            String number = some.replaceAll("[^0-9]", "");
            System.out.println("number = " + number);
            char[] chars2 = number.toCharArray();
            int sum = 0;
            for (char aChar : chars2) {
                String s2 = String.valueOf(aChar);
                int element = Integer.parseInt(s2);
                sum += element;
            }
            System.out.println("sum = " + sum);

            some = "v2as434fas234";
            numberRegex = "[^a-zA-Z]";  // оставляем в строке только буквы (латиница)
            String latins = some.replaceAll(numberRegex, "");
            System.out.println("latins = " + latins);

        }
}
