package e0125_JavaCore_II;

public class Sample25_NewThread extends Thread {
    boolean suspendFlag;

    Sample25_NewThread(String threadName, ThreadGroup tgOb) {
        super(tgOb, threadName);
        System.out.println("Новый поток :: ... " + this);
        suspendFlag = false;
        System.out.println(getName() + " : start() (конструктор)");
        start();
    }

    public void run() {
        System.out.println(getName() + " : START (run())");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(getName() + " => " + i);
                Thread.sleep(1000);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Исключение в потоке: " + getName());
        }
        System.out.println(getName() + " завершается.");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}

