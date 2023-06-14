package e0141_dmdev_level2_14_java_util_conturrent_Practice;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task1_41 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int seconds = scanner.nextInt();

            if (seconds < 0) {
                break;
            }

            threadExecutor.submit(() -> {
                Thread.sleep(seconds * 1000);
                System.out.printf("Поток спал `%s` спал `%d` секунд%n", Thread.currentThread().getName(), seconds);
                return seconds;
            });
        }

        threadExecutor.shutdown();
        threadExecutor.awaitTermination(10L, TimeUnit.MINUTES);

    }
}
