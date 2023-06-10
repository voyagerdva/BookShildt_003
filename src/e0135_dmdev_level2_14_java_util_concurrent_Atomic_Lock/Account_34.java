package e0135_dmdev_level2_14_java_util_concurrent_Atomic_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account_34 {
    private static int generator = 1;
    private final Lock lock = new ReentrantLock();
    private int money;
    private int id;

    public Account_34(int money) {
        this.money = money;
        this.id = generator++;
    }

    public void add(int money) {
        this.money += money;
    }

    public Lock getLock() {
        return lock;
    }

    public boolean takeOff(int money) {
        if (this.money >= money) {
            this.money -= money;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account_32{" +
                "money=" + money +
                ", id=" + id +
                '}';
    }
}
