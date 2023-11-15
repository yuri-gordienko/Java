package yugo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    public void run() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
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
        System.out.println("Exit                ->  0");
    }

    private void methods(BufferedReader reader, String select)  throws IOException {
        switch (select) {
            case "1"  -> dicSize(reader);
            case "2"  -> dicIsEmpty(reader);
            case "3"  -> dicContainsKey(reader);
            case "4"  -> dicContainsValue(reader);
            case "5"  -> dicVget(reader);
            case "6"  -> dicPut(reader);
            case "7"  -> dicRemove(reader);
            case "8"  -> dicPutAll(reader);
            case "9"  -> dicClear(reader);
            case "10" -> dicKeySet(reader);
            case "11" -> dicValues(reader);
            case "0" -> dicExit(reader);
        }
    }

    private void dicSize(BufferedReader reader) throws IOException {
    }

    private void dicIsEmpty(BufferedReader reader) throws IOException  {
    }

    private void dicContainsKey(BufferedReader reader) throws IOException  {
    }

    private void dicContainsValue(BufferedReader reader) throws IOException  {
    }

    private void dicVget(BufferedReader reader) throws IOException  {
    }

    private void dicPut(BufferedReader reader) throws IOException  {
    }

    private void dicRemove(BufferedReader reader) throws IOException  {
    }

    private void dicPutAll(BufferedReader reader) throws IOException  {
    }

    private void dicClear(BufferedReader reader) throws IOException  {
    }

    private void dicKeySet(BufferedReader reader) throws IOException  {
    }

    private void dicValues(BufferedReader reader) throws IOException  {
    }

    private void dicExit(BufferedReader reader) {
        System.out.println("Good buy!\n");
        System.exit(0);
    }
}
