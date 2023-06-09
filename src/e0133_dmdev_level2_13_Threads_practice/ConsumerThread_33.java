package e0133_dmdev_level2_13_Threads_practice;

import java.util.Queue;

public class ConsumerThread_33 implements Runnable {
    private final Queue<Integer> list;

    public ConsumerThread_33(Queue<Integer> list) {
        this.list = list;
    }


    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (!list.isEmpty()) {
                    Integer removedValue = list.remove();
                    System.out.println("Consumer get value: " + removedValue + ". Size: " + list.size() );
                } else {
                    System.out.println("Conrumer is waiting, list is empty!");
                }

                try {
                    int random = 50;
                    System.out.println("Consumer wait: " + random);
//                    list.notifyAll();
                    list.wait(random);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }

        }

    }
}
