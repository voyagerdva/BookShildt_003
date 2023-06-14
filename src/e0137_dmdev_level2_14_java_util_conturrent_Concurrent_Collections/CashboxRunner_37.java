package e0137_dmdev_level2_14_java_util_conturrent_Concurrent_Collections;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashboxRunner_37 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Cashbox_37> cashboxes = new ArrayBlockingQueue<>(2, true, List.of(new Cashbox_37(), new Cashbox_37()));

        List<Thread> threads = Stream.of(
                        new BuyerThread_37(cashboxes),
                        new BuyerThread_37(cashboxes),
                        new BuyerThread_37(cashboxes),
                        new BuyerThread_37(cashboxes),
                        new BuyerThread_37(cashboxes),
                        new BuyerThread_37(cashboxes),
                        new BuyerThread_37(cashboxes),
                        new BuyerThread_37(cashboxes)
                )
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }

    }
}
