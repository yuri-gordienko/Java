package yugo.tests_Andersen;

public class ThreadsDemo extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("C");
            System.out.println("D");
        }
    }
}
