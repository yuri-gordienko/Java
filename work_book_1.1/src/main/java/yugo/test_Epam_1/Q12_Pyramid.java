package yugo.test_Epam_1;

public class Q12_Pyramid {
    static int sideA = 3;
    int h = 5;

    public static void main(String[] arguments) {
        Q12_Pyramid p = new Q12_Pyramid();
        int ledge = 2, h = 15;
        System.out.print(ledge + h + p.sideA);
        System.out.println(" ");
        System.out.print(ledge + p.h + p.sideA);

    }
}