package yugo.test_Andersen;

public class Test extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("A");
            System.out.println("B");
        }
    }
}
