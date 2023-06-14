package e0138_dmdev_level2_14_java_util_conturrent_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class RocketDetailRunnable_38 implements Runnable {

    private final RocketDetail_38 rocketDetail;

    private final CountDownLatch countDownLatch;

    public RocketDetailRunnable_38(RocketDetail_38 rocketDetail, CountDownLatch countDownLatch) {
        this.rocketDetail = rocketDetail;
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        System.out.println("Готовится деталь: " + rocketDetail);
        try {
            Thread.sleep(1000L);
            System.out.println("Деталь готова: " + rocketDetail);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
