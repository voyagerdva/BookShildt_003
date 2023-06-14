package e0139_dmdev_level2_14_java_util_conturrent_CiclicBarrier;

import java.util.Arrays;
import java.util.concurrent.*;

public class BarrierDemo_39 {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(RocketDetail_39.values().length, () -> System.out.println("Пуск!"));
        ExecutorService threadPool = Executors.newCachedThreadPool();

        Arrays.stream(RocketDetail_39.values())
                .map(detail -> new RocketDetailRunnable_39(detail, cyclicBarrier))
                .forEach(threadPool::submit);

        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.MINUTES);
    }
}
