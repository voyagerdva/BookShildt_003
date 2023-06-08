package e0131_dmdev_level2_13_Threads_wait_notify;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashboxRunner_31 {
    public static void main(String[] args) throws InterruptedException {
        Queue<Cashbox_31> cashboxes = new ArrayDeque<>(List.of(new Cashbox_31(), new Cashbox_31()));

        List<Thread> threads = Stream.of(
                        new BuyerThread_31(cashboxes),
                        new BuyerThread_31(cashboxes),
                        new BuyerThread_31(cashboxes),
                        new BuyerThread_31(cashboxes),
                        new BuyerThread_31(cashboxes),
                        new BuyerThread_31(cashboxes),
                        new BuyerThread_31(cashboxes),
                        new BuyerThread_31(cashboxes)
                )
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }

    }
}
