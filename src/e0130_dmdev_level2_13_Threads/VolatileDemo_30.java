package e0130_dmdev_level2_13_Threads;

import java.util.List;


public class VolatileDemo_30 {

    private static boolean flag = false;


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (!flag) {
                System.out.println("still false");
            }
        });
        thread1.start();
        Thread.sleep(5L);

        Thread thread2 = new Thread(() -> {
            flag = true;
            System.out.println("flag is set");

        });
        thread2.start();

    }


}
