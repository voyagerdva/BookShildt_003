package e0120_TestApiStream_2_my_test_some_functions_in_StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample003 {
    private static Stream<String[]> getMapStream() {
        return Stream.of(new String[][] {
                {"CAR", "Audi"},
                {"BIKE", "Harley Davidson"}
        });
    }


    public static void main(String[] args) {
        Stream<String[]> stream = getMapStream();

        Map<String, String> vehicle = stream
                .collect(Collectors.toMap(
                         e -> e[0]
                        ,e -> e[1] ));

        System.out.println(vehicle);
    }
}
