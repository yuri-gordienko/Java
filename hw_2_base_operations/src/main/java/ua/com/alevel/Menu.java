package ua.com.alevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Menu {

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            variants(bf, select);
        }
    }
    private void menu() {
        System.out.println("_________________________________________________");
        System.out.println("- 'Sum of numbers', please enter  1");
        System.out.println("- 'Alphabet', please enter        2");
        System.out.println("- 'Lessons', please enter         3");
        System.out.println("- 'EXIT', please enter            0");
    }
    private void variants(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> numbers(reader);
            case "2" -> words(reader);
            case "3" -> lessons(reader);
            case "0" -> System.exit(0);
        }
        menu();
    }
    private void numbers(BufferedReader bf) throws IOException {
        System.out.println("You can Enter different symbols and get their sum:");
        Numbers num = new Numbers();
        System.out.println("symbol's sum is:" + " " + num.getNumbers(bf.readLine()));
    }
    private void words(BufferedReader bf) throws IOException {
        System.out.println("You can Enter different symbols and get its in order alphabet with quantity of each other:");
        String l = bf.readLine();
        char[] letters = l.toCharArray();
        Arrays.sort(letters);
        String line = String.copyValueOf(letters);
        for (int i = 0; i < letters.length; i++) {
            if (Character.isLetter(letters[i])) {
                System.out.println(letters[i] + " - " + (line.lastIndexOf(letters[i]) - line.indexOf(letters[i]) + 1));
                i += (line.lastIndexOf(letters[i]) - line.indexOf(letters[i]));
            }
        }
    }
    private void lessons(BufferedReader bf) throws IOException {
        System.out.println("You can Enter the lesson's number from 1 - 10, which you want to know about end:");
        School el = new School();
        el.lesson(Integer.parseInt(bf.readLine()));
    }
}