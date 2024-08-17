package yugo.test_Andersen;

public class ThreadsDemo1 extends Thread {

    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("A");
            System.out.println("B");
        }
    }
}