package e0133_dmdev_level2_13_Threads_practice;

import java.util.LinkedList;
import java.util.Queue;

public class TaskDemo_33 {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        Thread producerThread = new Thread(new ProducerThread_33(queue));
        Thread consumerThread = new Thread(new ConsumerThread_33(queue));

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}
