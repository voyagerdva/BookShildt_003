package e0137_dmdev_level2_14_java_util_conturrent_Concurrent_Collections;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class BuyerThread_37 implements Runnable {
    private final BlockingQueue<Cashbox_37> cashboxes;

    public BuyerThread_37(BlockingQueue<Cashbox_37> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            Cashbox_37 cashbox = cashboxes.take();
            System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " освободаю кассу " + cashbox);
            cashboxes.add(cashbox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

