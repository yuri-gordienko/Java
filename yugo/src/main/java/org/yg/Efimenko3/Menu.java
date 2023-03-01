package org.yg.Efimenko3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select options:");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            tasks(bf, select);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("first task, please enter 1");
        System.out.println("second task, please enter 2");
        System.out.println("third task, please enter 3");
        System.out.println("end, please enter 0");

    }

    private void tasks(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> firstTask(reader);
            case "2" -> secondTask(reader);
            case "3" -> thirdTask(reader);
            case "0" -> System.exit(0);
        }
        menu();
    }

    private void firstTask(BufferedReader reader) throws IOException {
        System.out.println("enter digits to sum them: ");
        DigitsSum digitsSum = new DigitsSum();
        System.out.println("sum of digits that you entered -> " +
                digitsSum.getDigits(reader.readLine()));
    }

    private void secondTask(BufferedReader reader) throws IOException {
        System.out.println("enter some string to count letters in it:");
        CountOfCharacters countOfCharacters = new CountOfCharacters();
        countOfCharacters.countOfLetters(reader.readLine());
    }

    private void thirdTask(BufferedReader reader) throws IOException {
        System.out.println("enter number of lesson to get time of the end:");
        EndOfLessons end = new EndOfLessons();
        end.timeOfLesson(Integer.parseInt(reader.readLine()));
    }
}