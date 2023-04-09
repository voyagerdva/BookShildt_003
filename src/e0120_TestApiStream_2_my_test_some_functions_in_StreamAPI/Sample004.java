package e0120_TestApiStream_2_my_test_some_functions_in_StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample004 {
    public static void main(String[] args) {
        System.out.println("\n>.. Случай 1. Нет повторов:");
        List<User004> users1 = Arrays.asList(
                new User004("Tom", 25),
                new User004("Victor", 32),
                new User004("Alex", 40),
                new User004("Bob", 25),
                new User004("Maxim", 25)
        );

        Map<String, Integer> mapUsers1 = users1.stream()
                .collect(Collectors.toMap(
                        k -> k.getName(),
                        k -> k.getAge()
                ));

        mapUsers1.entrySet().stream().forEach(System.out::println);

        //====================================================================================

        System.out.println("\n>.. Случай 2. Есть повторы:");
        List<User004> users2 = Arrays.asList(
                new User004("Tom", 25),
                new User004("Victor", 32),
                new User004("Alex", 40),
                new User004("Bob", 25),
                new User004("Maxim", 25),
                new User004("Maxim", 32)
        );

        Map<String, Integer> mapUsers2 = users2.stream()
                .collect(Collectors.toMap(
                        k -> k.getName(),
                        v -> v.getAge(),
                        ((v1, v2) -> Math.min(v1, v2))

                ));
        mapUsers2.entrySet().stream().forEach(System.out::println);

        //====================================================================================

        System.out.println("\n>.. Случай 3. Есть повторы и конкретная мапка:");
        List<User004> users3 = Arrays.asList(
                new User004("Tom", 25),
                new User004("Victor", 32),
                new User004("Alex", 40),
                new User004("Bob", 25),
                new User004("Maxim", 25),
                new User004("Maxim", 32)
        );

        Map<String, Integer> mapUsers3 = users3.stream()
                .collect(Collectors.toMap(
                        k -> k.getName(),
                        v -> v.getAge(),
                        (v1, v2) -> Math.min(v1, v2),
                        TreeMap::new)

                );
        mapUsers3.entrySet().stream().forEach(System.out::println);



    }
}
