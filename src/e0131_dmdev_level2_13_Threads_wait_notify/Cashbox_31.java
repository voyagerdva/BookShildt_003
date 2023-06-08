package e0131_dmdev_level2_13_Threads_wait_notify;

public class Cashbox_31 {
    private static int generator = 1;
    private int id;

    public Cashbox_31() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "Cashbox{" +
                "id=" + id +
                '}';
    }
}
