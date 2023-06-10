package e0136_dmdev_level2_14_java_util_concurrent_PoolThread;

import java.util.concurrent.Executors;

public class ThreadPoolDemo_36 {
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(5);
        Executors.newCachedThreadPool();

        Executors.newScheduledThreadPool(3);
        Executors.newWorkStealingPool();

    }
}
