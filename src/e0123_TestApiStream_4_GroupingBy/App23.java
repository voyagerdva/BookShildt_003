package e0123_TestApiStream_4_GroupingBy;

import java.util.*;
import java.util.stream.Collectors;

public class App23 {
    public void run() {
        List<Worker23> workers = Arrays.asList(
                new Worker23("Ned", 10, 1000, "engineer"),
                new Worker23("Robb", 15, 2000, "engineer"),
                new Worker23("Arya", 15, 1000, "engineer"),
                new Worker23("Aegon", 17, 6000, "ekonomist"),
                new Worker23("Daenerys", 17, 4000, "ekonomist"),
                new Worker23("Jaime", 22, 1000, "boss"),
                new Worker23("Tyrion", 22, 3000, "boss"));


        Map<String, List<Worker23>> map1;

        workers.stream()
                .collect(Collectors.groupingBy(Worker23::getPosition))
                .entrySet().stream()

                ;



//        for (String key : map1.keySet()) {
//            List<Worker22> valuesList = map1.get(key);
//            System.out.println(key + " : " + valuesList.stream().collect(Collectors.toMap(k -> k.getName()));
//        }


//        System.out.println(map1);




    }
}
