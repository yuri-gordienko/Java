package yugo.test_Andersen;

public class ThreadsDemo2 extends Thread {

    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("C");
            System.out.println("D");
        }
    }
}