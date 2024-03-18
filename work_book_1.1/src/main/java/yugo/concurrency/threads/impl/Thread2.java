package yugo.concurrency.threads.impl;

public class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Выполняем операцию внутри метода run() class Thread2");
        System.out.println("Runnable-2.1");
        System.out.println("Runnable-2.2");
        System.out.println("Runnable-2.3");
        System.out.println("Runnable-2.4");
        System.out.println("Runnable-2.5");
        System.out.println("Runnable-2.6");
    }
}
