package e0140_dmdev_level2_14_java_util_conturrent_Concurrent_Semaphore;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class BuyerThread_40 implements Runnable {
    private final Semaphore cashboxes;

    public BuyerThread_40(Semaphore cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            cashboxes.acquire();

            System.out.println(Thread.currentThread().getName() + " обслуживается в какой-то кассе");
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " освободаю какую-то кассу ");

            cashboxes.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

