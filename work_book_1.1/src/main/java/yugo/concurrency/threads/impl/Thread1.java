package yugo.concurrency.threads.impl;

public class Thread1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Выполняем операцию внутри метода run() class Thread1");
        System.out.println("Runnable-1.1");
        System.out.println("Runnable-1.2");

        try {
            // Затримка потоку на ... (1000 мілісекунд - 1 секунда)
            // Обов'язково враховуйте, що метод sleep викидає InterruptedException, який слід відловлювати або обробляти
            // відповідним чином.
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread.wakeup!");
        System.out.println("Runnable-1.3");
        System.out.println("Runnable-1.4");
        System.out.println("Runnable-1.5");
        System.out.println("Runnable-1.6");
    }
}
