package e0140_dmdev_level2_14_java_util_conturrent_Concurrent_Semaphore;

public class Cashbox_40 {
    private static int generator = 1;
    private int id;

    public Cashbox_40() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "Cashbox{" +
                "id=" + id +
                '}';
    }
}
