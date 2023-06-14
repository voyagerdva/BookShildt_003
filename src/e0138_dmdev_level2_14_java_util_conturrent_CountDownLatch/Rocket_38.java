package e0138_dmdev_level2_14_java_util_conturrent_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Rocket_38 implements Runnable {

    private final CountDownLatch countDownLatch;

    public Rocket_38(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;

    }


    @Override
    public void run() {
        System.out.println("Ракета готовится к запуску...");
        try {
            countDownLatch.await();
            System.out.println("Пуск!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
