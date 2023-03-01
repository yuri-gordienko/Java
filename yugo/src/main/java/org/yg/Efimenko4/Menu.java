package org.yg.Efimenko4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the StringUtils");
        System.out.println("Select options:");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            crud(bf, select);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("usual reverse ->  1");
        System.out.println("substring reverse -> 2");
        System.out.println("substring reverse with indexes -> 3");
        System.out.println("If you want close, please enter 0");
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> usualReverse(reader);
            case "2" -> substringReverse(reader);
            case "3" -> reverseWithIndexes(reader);
            case "0" -> System.exit(0);
        }
        menu();
    }

    private void substringReverse(BufferedReader reader) throws IOException {
        System.out.println("enter your string");
        String userString = reader.readLine();
        System.out.println("enter substring in your string to reverse");
        String substringToReverse = reader.readLine();
        System.out.println(StringUtils.reverse(userString, substringToReverse));
    }

    public void usualReverse(BufferedReader reader) throws IOException {
        System.out.println("enter your string");
        System.out.println(StringUtils.reverse(reader.readLine()));
    }

    public void reverseWithIndexes(BufferedReader reader) throws IOException {
        System.out.println("enter your string");
        String userString = reader.readLine();
        System.out.println("enter first index");
        int firstIndex = Integer.parseInt(reader.readLine());
        System.out.println("enter second index");
        int secondIndex = Integer.parseInt(reader.readLine());
        System.out.println(StringUtils.reverse(userString, firstIndex, secondIndex));
    }
}