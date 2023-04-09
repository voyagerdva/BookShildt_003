package e0120_TestApiStream_2_my_test_some_functions_in_StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample005 {
    public static void main(String[] args) {
        Stream<String> strStream = Stream.of("asd", "aaa", "bbb");
//        strStream.forEach(System.out::println);

        Stream<String> stream_ABC = Arrays.stream(new String[]{"A", "B", "C"});
        Stream<String> stream_123 = Arrays.stream(new String[]{"1", "2", "3"});

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        list1.add("ONE");
        list1.add("TWO");
        list1.add("THREE");
        list1.add("FOUR");

        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");

        System.out.println(list1);
        System.out.println(list2);


        System.out.println();

        //=======================================================================================

        int i = 0;
        for (String item : list1) {

        }


        List<Double> arrayList1 = Arrays.asList(1.0,2.0,3.0);
        List<Double> arrayList2 = Arrays.asList(4.0,5.0,6.0);

        // пример из инета - поэлементное сложение элементов двух списков на 1й позиции:
        System.out.println(
        IntStream.range(0, Math.min(arrayList1.size(), arrayList2.size()))
                .mapToDouble(j -> arrayList1.get(j) + arrayList2.get(j))
                .collect(() -> new ArrayList<Double>(),
                        (c, e) -> c.add(e),
                        (c1, c2) -> c1.addAll(c2))
                .toString()
        );






        // я сам придумал. Создание словаря из двух списков - ключ = значение
        HashMap<String, String> dict = new HashMap<>();
        for (int j = 0; j < Math.min(list1.size(), list2.size()); j++) {
            dict.put(list1.get(j), list2.get(j));
        }
        System.out.println(dict);





//        Map<String, String> val = Stream.concat(list1.stream(), list2.stream())
//                .collect(Collectors.toMap(
//                        item -> {
//                            return (list1.contains(item)) ? item : "NULL";
//                        },
//
//                        item -> {
//                            return (list2.contains(item)) ? item : "NULL";
//                        },
//
//                        (a, b) -> a.concat(" " + b)
//
//
//                ));
////                .entrySet().forEach(System.out::println);
////                .forEach(item -> item. System.out::println);
//
//        val.entrySet().forEach(System.out::println);

        ;

    }
}
