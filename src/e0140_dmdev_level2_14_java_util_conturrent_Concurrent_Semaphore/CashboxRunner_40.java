package e0140_dmdev_level2_14_java_util_conturrent_Concurrent_Semaphore;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashboxRunner_40 {
    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue<Cashbox_40> cashboxes = new ArrayBlockingQueue<>(2, true, List.of(new Cashbox_40(), new Cashbox_40()));

        Semaphore cashboxes = new Semaphore(2);
        List<Thread> threads = Stream.of(
                        new BuyerThread_40(cashboxes),
                        new BuyerThread_40(cashboxes),
                        new BuyerThread_40(cashboxes),
                        new BuyerThread_40(cashboxes),
                        new BuyerThread_40(cashboxes),
                        new BuyerThread_40(cashboxes),
                        new BuyerThread_40(cashboxes),
                        new BuyerThread_40(cashboxes)
                )
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }

    }
}
