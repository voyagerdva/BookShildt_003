package e0136_dmdev_level2_14_java_util_concurrent_PoolThread;

import java.util.Optional;
import java.util.Queue;

public class PoolThread_36 extends Thread {
    private final Queue<Runnable> tasks;


    public PoolThread_36(Queue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            Optional<Runnable> task = Optional.empty();
            synchronized (tasks) {
                if (!tasks.isEmpty()) {
                    task = Optional.of(tasks.remove());
                }
            }

            task.ifPresent(Runnable::run);
        }
    }
}
