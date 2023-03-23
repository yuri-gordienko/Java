package ua.com.alevel.controller;

import ua.com.alevel.service.ServiceHashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class ControllerHashMap {

    ServiceHashMap<String, String> states = new ServiceHashMap<String, String>();
    ServiceHashMap<String, String> countries = new ServiceHashMap<String, String>();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        states.put("804", "Ukraine");
        states.put("276", "Germany");
        states.put("840", "USA");
        states.put("076", "Brazil");
        states.put("702", "Singapore");
        states.put("036", "Australia");

        System.out.println("________________________________________________________________________                                            ");
        System.out.println("We greet you!                                                           |           Справочная инфо. для меню (K, V)");
        System.out.println("< INTERNATIONAL ORGANISATION for STANDARDIZATION >                      |            804-Ukraine       276-Germany  ");
        System.out.println("                                                                        |            840-USA           076-Brazil   ");
        System.out.println("Data base information:                                                  |            702-Singapore     036-Australia");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            cases(bf, select);
        }
    }

    public void menu() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Size of Data base, please Enter:                                       1");
        System.out.println("Check ISO in table, please Enter:                                      2");
        System.out.println("Check Country in table, please Enter:                                  3");
        System.out.println("Find Country bi ISO, please Enter:                                     4");
        System.out.println("Delete Country by ISO, please Enter:                                   5");
        System.out.println("Remove all Data from table 'State' to table 'Countries', please Enter: 6");
        System.out.println("Update Data base of table 'State', please Enter:                       7");
        System.out.println("Delete all Countries from table 'State', please Enter:                 8");
        System.out.println("Remove all Data from table 'Countries' to table 'State', please Enter: 9");
        System.out.println("Check of table's Data state, please Enter:                            10");
        System.out.println("If you want to EXIT, please Enter:                                     0");
        System.out.println("------------------------------------------------------------------------");
    }

    public void cases(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> size(reader);
            case "2" -> key(reader);
            case "3" -> value(reader);
            case "4" -> getByK(reader);
            case "5" -> removeC(reader);
            case "6" -> removeDataToTable(reader);
            case "7" -> updateS(reader);
            case "8" -> deleteS(reader);
            case "9" -> removeDataToCount(reader);
            case "10" -> checkDataTAbles(reader);
            case "0" -> System.exit(0);
        }
        menu();
    }

    public void size(BufferedReader reader) throws IOException {
        System.out.println("Size of Data base: " + states.size());
    }

    public void key(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ISO which you want to check: ");
        String iso1 = reader.readLine();
        System.out.println("ISO in table: " + iso1 + " is " + states.containsKey(iso1));
    }

    public void value(BufferedReader reader) throws IOException {
        System.out.println("Please enter the name of the Country which you want to check: ");
        String c = reader.readLine();
        System.out.println("Country in table: " + c + " is " + states.containsValue(c));
    }

    public void getByK(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ISO of the Country which you want to SEE: ");
        String c = reader.readLine();
        System.out.println("Country in table: " + c + " is " + states.get(c));
    }

    public void removeC(BufferedReader reader) throws IOException {
        System.out.println("Please enter the ISO of the Country which you want to Delete: ");
        String c = reader.readLine();
        System.out.println("Country in table: " + c + " is " + states.remove(c));
        System.out.println("Country " + c + " was Deleted");
    }

    public void removeDataToTable(BufferedReader reader) throws IOException {
        countries.putAll(states);
        System.out.println("Table 'State' was" + states);
        System.out.println("Table 'Countries' is" + countries);
    }

    public void updateS(BufferedReader reader) throws IOException {
        System.out.println("Data of table is:");
        Collection<String> values = states.values();
        for (String value : values) {
            System.out.println("- " + value);
        }
    }

    public void deleteS(BufferedReader reader) throws IOException {
        states.clear();
        System.out.println("State of table is" + states + ";  table 'State' is empty?  - " + states.isEmpty());
    }

    public void removeDataToCount(BufferedReader reader) throws IOException {
        states.putAll(countries);
        System.out.println("Data base of Table 'State' was Updated");
        System.out.println("Table 'State' is " + states);
    }

    public void checkDataTAbles(BufferedReader reader) throws IOException {
        System.out.println("Table 'State' is empty? " + states.isEmpty());
        System.out.println("Table 'Countries' is empty? " + countries.isEmpty());
    }
}
