package yugo.tests_Andersen;

public class Test2 extends Thread {
    Test2() {
        System.out.println("My Thread");
    }

    public void run() {
        System.out.println("bar");
    }

    public void run(String s) {
        System.out.println("baz");
    }
}
