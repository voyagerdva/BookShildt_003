package e0115_Lambda_13_Andrey_A_B_C;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class B15 {
    public void runB() {
        InterfaceA15 aaa = new A15();

        Supplier<? extends InterfaceA15> b = aaa::get;
        InterfaceA15 str = b.get();


        aaa.get3((s) -> "bla");
        aaa.get3(aaa::get2);


        Function<String, String> get2Func = aaa::get2;

        Building15 build1 = new Building15("B1");
        Building15 build2 = new Building15("B2");

        Address15 address1 = new Address15("street1", build1, new ArrayList<>());
        Address15 address2 = new Address15("street2", build2, new ArrayList<>());
        Address15 address3 = new Address15("street3", build1, new ArrayList<>());
        Address15 address4 = new Address15("street4", build2, new ArrayList<>());


        List<A15> list = new ArrayList<>();
        list.add(new A15("name1", address1));
        list.add(new A15("name2", address2));
        list.add(new A15("name3", address3));
        list.add(new A15("name4", address4));

        Map<String, Address15> map = list.stream()
                .map(a -> a.address)
                .collect(Collectors.toMap(a -> a.street, a -> a));
        map.forEach((k,v) -> System.out.println(k + " - " + v.street + "." + v.building));

        Supplier<Map<String, Map<String, Address15>>> k1;


        HashMap<Building15, Map<String, Address15>> map2 = list.stream()
                .map(a -> a.address)
                .collect(Collectors.groupingBy(
                        a -> a.building,
                        HashMap::new,
                        Collectors.toMap(a -> a.street, a -> a)));

        map2.forEach((k2,v2) -> {
            System.out.println(k2.building + ":");
            v2.forEach((k,v) -> System.out.println(k + " - " + v.street + "." + v.building));

        });

        HashMap<Building15, List<Address15>> map3 = list.stream()
                .map(a -> a.address)
                .collect(Collectors.groupingBy(
                        a -> a.building,
                        HashMap::new,
                        Collectors.toList()));


        System.out.println();
        map3.forEach((k3,v3) -> {
            System.out.println(k3.building + ":");
            v3.forEach((a) -> System.out.println(a.street + "." + a.building));

        });

    }



}
