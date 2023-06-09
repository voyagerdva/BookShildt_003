package e0132_dmdev_level2_13_Threads_deadlock;

public class Account_32 {
    private static int generator = 1;
    private int money;
    private int id;

    public Account_32(int money) {
        this.money = money;
        this.id = generator++;
    }

    public void add(int money) {
        this.money += money;
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
