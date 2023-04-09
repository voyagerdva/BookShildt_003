package e0102_Meta_Wildcard_2_training;

public class F {
    public <T> F(T t) {
        System.out.println(t.getClass().getName());
    }
}

