package yugo.controller;

import yugo.entity.Dictionary;
import yugo.service.DictionaryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    DictionaryService dictionaryService = new DictionaryService();

    public void run() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Dictionary dic = new Dictionary();
        dic.setKey("1");
        dic.setValue("Yuri Gordienko");
        dictionaryService.put(dic);

        Dictionary dictionary2 = new Dictionary();
        dictionary2.setKey("2");
        dictionary2.setValue("Artem Berdnikov");
        dictionaryService.put(dictionary2);

        Dictionary dictionary = new Dictionary();
        dictionary.setKey("2");
        dictionary.setValue("Kate Berdnikova");
        dictionaryService.put(dictionary);

        Dictionary dictionary3 = new Dictionary();
        dictionary3.setKey("3");
        dictionary3.setValue("Artem Berdnikov");
        dictionaryService.put(dictionary3);

        System.out.println("\nData base Dictionary:\nChoose methods:");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            methods(bf, select);
        }
    }

    private void menu() {
        System.out.println("----------------------------------------------------");
        System.out.println(".size()             ->  1");
        System.out.println(".isEmpty()          ->  2");
        System.out.println(".containsKey(k)     ->  3");
        System.out.println(".containsValue(v)   ->  4");
        System.out.println(".V get(k)           ->  5");
        System.out.println(".put(k, v)          ->  6");
        System.out.println(".remove(k)          ->  7");
        System.out.println(".putAll(k, v)       ->  8");
        System.out.println(".clear()            ->  9");
        System.out.println(".keySet()           -> 10");
        System.out.println(".values()           -> 11");
        System.out.println("Show all objects    -> 12");
        System.out.println("Exit                ->  0");
    }

    private void methods(BufferedReader reader, String select)  throws IOException {
        switch (select) {
            case "1"  -> dicSize(reader);
            case "2"  -> dicIsEmpty(reader);
            case "3"  -> dicContainsKey(reader);
            case "4"  -> dicContainsValue(reader);
            case "5"  -> dicVgetByKey(reader);
            case "6"  -> dicPut(reader);
            case "7"  -> dicRemove(reader);
            case "8"  -> dicPutAll(reader);
            case "9"  -> dicClear(reader);
            case "10" -> dicKeySet(reader);
            case "11" -> dicValues(reader);
            case "12" -> allObjects(reader);
            case "0" -> dicExit(reader);
        }
        menu();
    }

    private void dicSize(BufferedReader reader) throws IOException {
        System.out.println("Size - " + dictionaryService.size());
    }

    private void dicIsEmpty(BufferedReader reader) throws IOException  {
        System.out.println(dictionaryService.isEmpty());
    }

    private void dicContainsKey(BufferedReader reader) throws IOException  {
        System.out.println("Enter key:");
        System.out.println(dictionaryService.containsKey(reader.readLine()));
    }

    private void dicContainsValue(BufferedReader reader) throws IOException  {
        System.out.println("Enter value:");
        System.out.println(dictionaryService.containsValue(reader.readLine()));
    }

    private void dicVgetByKey(BufferedReader reader) throws IOException  {
        System.out.println("Enter key:");
        String key = reader.readLine();
        System.out.println("- " + dictionaryService.getValueByKey(key));
    }

    private void dicPut(BufferedReader reader) throws IOException  {
        Dictionary dic = new Dictionary();

        System.out.println("Enter key:");
        String key = reader.readLine();
        System.out.println("Enter value");
        String value = reader.readLine();

        dic.setKey(key);
        dic.setValue(value);
        dictionaryService.put(dic);
    }

    private void dicRemove(BufferedReader reader) throws IOException  {
        System.out.println("Enter key:");
        String key = reader.readLine();
        dictionaryService.remove(key);
    }

    private void dicPutAll(BufferedReader reader) throws IOException  {
        Dictionary[] dic = dictionaryService.copyArrays();
        for (Dictionary dictionary : dic) {
            if (dictionary != null) {
                System.out.println(dictionary);
            }
        }
    }

    private void dicClear(BufferedReader reader) throws IOException  {
        dictionaryService.clear();
    }

    private void dicKeySet(BufferedReader reader) throws IOException  {
        String[] keys = dictionaryService.keySet();
        for (String key : keys) {
            System.out.println("- " + key);
        }
    }

    private void dicValues(BufferedReader reader) throws IOException  {
        String[] values = dictionaryService.values();
        for (String value : values) {
            System.out.println("- " + value);
        }
    }

    private void allObjects(BufferedReader reader) throws IOException  {
        Dictionary[] dic = dictionaryService.readAll();
        for (Dictionary dictionary : dic) {
            if (dictionary != null) {
                System.out.println(dictionary);
            }
        }
    }

    private void dicExit(BufferedReader reader) {
        System.out.println("Good buy!\n");
        System.exit(0);
    }
}
