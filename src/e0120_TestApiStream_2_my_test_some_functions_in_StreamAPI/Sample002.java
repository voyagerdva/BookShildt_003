

package e0120_TestApiStream_2_my_test_some_functions_in_StreamAPI;


import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Sample002 {
    public static void main(String[] args) {
        List<Point002> points = Arrays.asList(
                Point002.of("0", "1"),
                Point002.of("1", "2"),
                Point002.of("1", "1"),
                Point002.of("1", "3"),
                Point002.of("3", "4")
        );

//        Map<Integer, Integer> map = points.stream()
//                .collect(Collectors.toMap(
//                         Point002::getX
//                        ,Point002::getY
//                ));

        Map<String, String> map2 = points.stream()
                .collect(Collectors.toMap(
                         k -> k.x
                        ,v -> v.y
//                        ,(oldV, newV) -> oldV
//                        ,(a, b) -> String.join(", ", a, b)
                        ,(a,b) -> a.concat(" " + b)
                ));

        map2.entrySet().stream()
                .forEach(item -> System.out.println(item));

//        System.out.println(map);
        System.out.println();
        System.out.println(map2);

    }
}
