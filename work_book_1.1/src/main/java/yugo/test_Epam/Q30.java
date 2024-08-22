package yugo.test_Epam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q30 {

    public static void main(String[] args) {

        try {
            Scanner scan = new Scanner("null 1 7.00 false");
            scan.useDelimiter(" ");
            String str = scan.next();
            int x = scan.nextInt();
            float f = scan.nextFloat();
            boolean match = scan.nextBoolean();
            System.out.print(str + "," + x + "," + f + "," + match);
        } catch (InputMismatchException e) {
            System.out.println("e = " + e);
        }
    }
}
