package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControllerLib {

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("*************************************************************************************************************************************");
        System.out.println("Hallo, welcome to the Library Lang Utils:");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            cases(bf, select);
        }
    }

    public void menu() {
        System.out.println("________________________________________________________________________________________");
        System.out.println("If you want to reverse Words one by one, please Enter:                                 1");
        System.out.println("If you want to reverse Words by specified range of letters, please Enter:              2");
        System.out.println("If you want to reverse Words from specified range of indexes start/end, please Enter:  3");
        System.out.println("If you want to EXIT, please Enter:                                                     0");
    }

    public void cases(BufferedReader reader, String select) throws IOException {
        switch(select) {
            case "1" -> stringRevers(reader);
            case "2" -> specifiedRevers(reader);
            case "3" -> charRevers(reader);
            case "0" -> System.exit(0);
        }
        menu();
    }

    public void stringRevers(BufferedReader reader) throws IOException {
        System.out.println("Please, Enter the Words:");
        String text = reader.readLine();
        String str = new String();
        String[] string = text.split(" ");
        for (String s : string) {
            s = StringUtils.reverse(s);
            System.out.println(s);
        }
    }

    public void specifiedRevers(BufferedReader reader) throws IOException {
        System.out.println("Please, Enter the Words:");
        String text = reader.readLine();
        System.out.println("Please, Enter the specified range of letters to reversing:");
        String textToRev = reader.readLine();
        System.out.println(ServiceLib.specifiedRevers(text, textToRev));
    }

    public void charRevers(BufferedReader reader) throws IOException {
        System.out.println("Please, Enter the Words:");
        String text = reader.readLine();
        System.out.println("Please, Enter first Index:");
        String text1 = reader.readLine();
        int firstIndex = Integer.parseInt(text1);
        System.out.println("Please, Enter last Index:");
        String text2 = reader.readLine();
        int lastIndex = Integer.parseInt(text2);
        System.out.println(ServiceLib.reverseBiIndexes(text, firstIndex, lastIndex));
    }
}



