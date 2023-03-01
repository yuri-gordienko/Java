package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;

public class ControllerLib {

    private ServiceLib serviceLib = new ServiceLib();

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
            System.out.println("_____________________________________________________________________");
            System.out.println("If you want to do String reverse, please Enter:                                           1");
            System.out.println("If you want to do specified String reverse, please Enter:                                 2");
            System.out.println("If you want to do full functional of String reverse with char start/end, please Enter:    3");
            System.out.println("If you want to EXIT, please Enter:                                                        0");
        }
        public void cases(BufferedReader reader, String select) throws IOException {
            switch (select) {
                case "1" -> wordRevers(reader);
//                case "2" -> spesRevers(reader);
//                case "3" -> charRevers(reader);
                case "0" -> System.exit(0);
            }
            menu();
        }
        public void wordRevers(BufferedReader reader) throws IOException {
            System.out.println("Please, Enter the String:");
            String readingWord = reader.readLine();
            String[] strings = readingWord.split(" ");
            for (String string : strings) {
                System.out.println("Variant 1: " + StringUtils.reverse(string));
            }
            System.out.println("Variant 2:" + StringUtils.reverse(readingWord));
        }


































//        public void spesRevers(BufferedReader reader) throws IOException {
//            System.out.println("Please, Enter the String:");
//            String readingWord = reader.readLine();
//            System.out.println("Please, Enter the letters, which you want to reverse:");
//            String reversWord = reader.readLine();
//            System.out.println(StringUtils.reverse(readingWord,reversWord));
//        }
//        public void charRevers(BufferedReader reader) throws IOException {
//            System.out.println("Please, Enter the String and char start/stop:");
//
//        }



}
