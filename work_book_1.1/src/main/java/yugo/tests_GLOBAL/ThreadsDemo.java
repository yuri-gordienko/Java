package yugo.tests_GLOBAL;

public class ThreadsDemo extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("C");
            System.out.println("D");
        }
    }
}
