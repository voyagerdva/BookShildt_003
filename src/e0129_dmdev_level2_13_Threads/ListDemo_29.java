package e0129_dmdev_level2_13_Threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo_29 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());


        ListThread_29 listThread_29_1 = new ListThread_29(integers);
        ListThread_29 listThread_29_2 = new ListThread_29(integers);
        ListThread_29 listThread_29_3 = new ListThread_29(integers);
        ListThread_29 listThread_29_4 = new ListThread_29(integers);
        ListThread_29 listThread_29_5 = new ListThread_29(integers);
        ListThread_29 listThread_29_6 = new ListThread_29(integers);
        ListThread_29 listThread_29_7 = new ListThread_29(integers);

        listThread_29_1.start();
        listThread_29_2.start();
        listThread_29_3.start();
        listThread_29_4.start();
        listThread_29_5.start();
        listThread_29_6.start();
        listThread_29_7.start();

        listThread_29_1.join();
        listThread_29_2.join();
        listThread_29_3.join();
        listThread_29_4.join();
        listThread_29_5.join();
        listThread_29_6.join();
        listThread_29_7.join();

        System.out.println(integers);







    }
}
