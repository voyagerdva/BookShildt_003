package e0133_dmdev_level2_13_Threads_practice;

import javax.swing.*;
import java.util.Queue;

public class ProducerThread_33 implements Runnable {
    private final Queue<Integer> list;

    public ProducerThread_33(Queue<Integer> list) {
        this.list = list;
    }


    @Override
    public void run() {
        synchronized (list) {
            while (true) {

                if (list.size() < 10) {
                    int random = RandomUtil_33.getRandom();
                    list.add(random);
                    System.out.println("Producer adds value: " + random + ". Size " + list.size());
                } else {
                    System.out.println("Producer does nothing!");
                }
//                list.notifyAll();
                try {
//                    int randomWaitValue = RandomUtil_33.getRandom(5);
                    int randomWaitValue = 20    ;
                    System.out.println("Producer waits: " + randomWaitValue);
                    list.wait(randomWaitValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
