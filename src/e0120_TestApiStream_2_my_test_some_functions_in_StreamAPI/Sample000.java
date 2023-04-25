package e0120_TestApiStream_2_my_test_some_functions_in_StreamAPI;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample000 {
    public static void main(String[] args) {
//        Stream.iterate("begin:", x -> x + 3)
//                .limit(6)
//                .forEach(System.out::println);
//        // 2, 8, 14, 20, 26, 32
//
    //
//        Stream.Builder<Integer> streamBuider = Stream.<Integer>builder()
//                .add(0)
//                .add(1)
//                .add(5);
//
//        streamBuider.add(8);
//        streamBuider.accept(4);
//        streamBuider.add(8);
//
//
////        for (int i = 2; i <= 8; i += 2) {
////            streamBuider.accept(i);
////        }
//
//
//        streamBuider
//                .add(9)
//                .add(10)
//                .build()
//                .forEach(System.out::println);


        //=====================================================================
//        System.out.println();
//        Stream.of("11", "111", "1111")
//                .map(x -> Integer.parseInt(x, 2))
//                .forEach(System.out::println);


        //======================================================================

//        Stream.of(1, 2, 3, 4, 5, 6)
//                .flatMap(x -> {
//                    switch (x % 3) {
//                        case 0:
//                            return Stream.of(x, x*x, x*x*2);
//                        case 1:
//                            return Stream.of(x);
//                        case 2:
//                        default:
//                            return Stream.empty();
//                    }
//                })
//                .forEach(x -> System.out.print(x + " "));

        Map<Integer, String> map4 = Stream.of(50, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                        i -> i % 5, //0,0,0, 4,4, 2
                        i -> String.format("'%d'", i),
                        (a, b) -> String.join(",", a, b),
                        TreeMap::new
                ));

        map4.forEach((k, v) -> System.out.println(k + " : " + v));

// {0="<50>, <55>, <20>", 2="<52>", 4="<64>, <19>"}


    }
}
