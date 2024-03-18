package yugo.concurrency;

import yugo.concurrency.threads.impl.Thread1;
import yugo.concurrency.threads.impl.Thread2;
import yugo.concurrency.threads.impl.Thread3;

public class ConcurrencyMain {

    public static void main(String[] args) {

//        Thread1 thread1 = new Thread1();
//        Thread thread = new Thread(thread1);
//        thread.start();

        new Thread(new Thread1()).setPriority(Thread.NORM_PRIORITY);
        new Thread(new Thread2()).setPriority(Thread.MIN_PRIORITY);
        new Thread(new Thread3()).setPriority(Thread.MAX_PRIORITY);

        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
        new Thread(new Thread3()).start();
    }
}
