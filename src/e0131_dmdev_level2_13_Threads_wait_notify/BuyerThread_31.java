package e0131_dmdev_level2_13_Threads_wait_notify;

import java.util.Queue;

public class BuyerThread_31 implements Runnable {
    private final Queue<Cashbox_31> cashboxes;

    public BuyerThread_31(Queue<Cashbox_31> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            synchronized (cashboxes) {
                while (true) {
                    if (!cashboxes.isEmpty()) {
                        Cashbox_31 cashbox = cashboxes.remove();
                        System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);

                        cashboxes.wait(5L);

                        System.out.println(Thread.currentThread().getName() + " освободаю кассу " + cashbox);
                        cashboxes.add(cashbox);
                        cashboxes.notifyAll();
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " ожидает свободную  кассу ");
                        cashboxes.wait();
                    }
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

