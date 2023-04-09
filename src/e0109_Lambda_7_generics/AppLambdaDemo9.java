package e0109_Lambda_7_generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppLambdaDemo9 {
    public void run() {
        SomeFuncInterface<String> reverse = (str) -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }

            return result;
        };

        SomeFuncInterface2 reverse2 = (str) -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
        };

        Function<String, String> reverse3 = (str) -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }

            return result;
        };


        run2(reverse3);

        run2((str) -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }

            return result;
        });

        SomeFuncInterface2 some2 = run3();
        System.out.println("T1");
        some2.func2("lkjlkjlkj");
        System.out.println("T2");

        List<String> list = new ArrayList<>();
        list.add("string_0");
        list.add("string_001");
        list.add("string_002");
        list.add("string_003");
        list.add("string_0031");
        list.add("string_0032");
        list.add("string_004");

        Stream<String> soldatList = getStringStream(list);

//        soldatList.collect(Collectors.toList());
//                .collect(Collectors.toList());

        getStringStream(list).forEach(s -> {
            System.out.println(s + " final " + s);
        });

        getStringStream(list).forEach(s -> {
            System.out.println(s + " final " + s);
        });

        System.out.println();
        soldatList.forEach(s -> {
            System.out.println(s + " final " + s);
        });

        Map<String, String> c = getStringStream(list).collect(Collectors.toMap(k -> k, v -> v));
        c.forEach((k,v) -> System.out.println("MapValue = " + k + " " + v));

    }

    private Stream<String> getStringStream(List<String> list) {
        Stream<String> soldatList = list.stream()
//                .skip(2)
//                .limit(2)
                .filter(s -> {
                    System.out.println(s + " filter1");
                    return s.startsWith("string_00");
                })
                .filter(s -> {
                    System.out.println(s + " filter2");
                    return s.startsWith("string_003");
                })
                .map(s -> {
                    System.out.println(s + " map1");
                    return new Soldat(s);
                })
                .map(soldat -> {
                    System.out.println(soldat.name + " map2");
                    soldat.address = "s1";
                    return soldat;
                })
                .flatMap(soldat -> {
                    Stream<String> stream = soldat.orders.stream()
                            .filter(s -> true);
                    return stream;
                });
        return soldatList;
    }

    public void run2(Function<String, String> f) {

        String str = f.apply("lkjlkj");
    }

    public SomeFuncInterface2 run3() {
        SomeFuncInterface2 a;
        a = (str) -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            System.out.println("Inside labma");
        };
        return a;

    }
}
