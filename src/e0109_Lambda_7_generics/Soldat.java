package e0109_Lambda_7_generics;

import java.util.ArrayList;
import java.util.List;

public class Soldat {
    public String name;
    public String address;
    public List<String> orders = new ArrayList<>();

    public Soldat(String s) {
        name = s;
        orders.add(name);
        orders.add(name + "_44444");

        orders.forEach(o -> {

        });

    }
}
