package e0137_dmdev_level2_14_java_util_conturrent_Concurrent_Collections;

public class Cashbox_37 {
    private static int generator = 1;
    private int id;

    public Cashbox_37() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "Cashbox{" +
                "id=" + id +
                '}';
    }
}
