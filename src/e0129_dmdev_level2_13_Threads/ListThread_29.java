package e0129_dmdev_level2_13_Threads;

import java.util.List;

public class ListThread_29 extends Thread{
    private final List<Integer> list;

    public ListThread_29(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
//            synchronized (list) {
                list.add(i);
//            }
        }
    }
}
