package yugo.test_Epam;

public class Q18_Main {

    public static void main(String[] args) {
        I1 i1 = new A();
        I2 i2 = new A();
        i1.m();
        i2.m();
    }

    interface I1 {
        default void m() {
            System.out.print("1");
        }
    }

    interface I2 {
        default void m() {
            System.out.print("2");
        }
    }

    static class A implements I1, I2 {   // line1
        public void m() {        // line2
            System.out.print("A");
        }
    }
}
