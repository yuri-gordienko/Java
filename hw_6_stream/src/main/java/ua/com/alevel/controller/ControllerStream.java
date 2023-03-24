package ua.com.alevel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ControllerStream {

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(" ");
        System.out.println("Hallo, Welcome to the STRING STATISTIC PROGRAMME                    ");
        System.out.println("Below, you can put your text and get statistic info about it:       ");

        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            cases(bf, select);
        }
    }

    public void menu() {
        System.out.println("                                                 ");
        System.out.println("For typing text, please enter....................1");
        System.out.println("EXIT.............................................0");
    }

    public void cases(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> string(reader);
            case "0" -> System.exit(0);
        }
        menu();
    }

    public void string(BufferedReader reader) throws IOException {
        System.out.println("You can enter text:");
        String text = reader.readLine();

        Map<String, Long> words = Arrays.stream(text.split("[^\\p{L}]+"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int sumW = words.values().stream().mapToInt(Math::toIntExact).sum();
        int rating = 1;

        System.out.println("Total_____________________________________________");
        System.out.println("|       Words     | Rating | Count  |      %      |");
        System.out.println("--------------------------------------------------");

        for (Map.Entry<String, Long> entry : words.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList()) {
            String string = entry.getKey();
            long count = entry.getValue();
            double percent = count * 100.0 / (double) sumW;

            String leftAlignFormat = "| %-15s | %-6d | %-6d | %-11.2f |%n";
            System.out.format(leftAlignFormat, string, rating++, count, percent);
        }
        System.out.println("|_________________________________________________|");
    }
}
