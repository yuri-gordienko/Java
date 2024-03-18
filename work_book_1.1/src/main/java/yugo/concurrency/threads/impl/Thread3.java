package yugo.concurrency.threads.impl;

public class Thread3 implements Runnable {

    @Override
    public void run() {
        System.out.println("Выполняем операцию внутри метода run() class Thread3");
        System.out.println("Runnable-3.1");
        System.out.println("Runnable-3.2");
        System.out.println("Runnable-3.3");
        System.out.println("Runnable-3.4");
        System.out.println("Runnable-3.5");
        System.out.println("Runnable-3.6");
    }
}
