package e0136_dmdev_level2_14_java_util_concurrent_PoolThread;

import java.util.concurrent.*;

public class ThreadPoolDemo_36 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        test();

        scheduleThread();


        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
        threadPool.scheduleAtFixedRate(() -> System.out.println("OK!"), 4L, 1L, TimeUnit.SECONDS);


    }

    private static void scheduleThread() throws InterruptedException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
        threadPool.schedule(() -> System.out.println("OK!"), 3L, TimeUnit.SECONDS);


        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);
    }

    private static void test() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(2000L );
            System.out.println("It s callable");
            return 1;
        });


        System.out.println("Redult: " + future.get());
        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);
        System.out.println("main end");
    }
}
