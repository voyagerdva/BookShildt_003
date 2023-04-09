package e0110_Lambda_8_generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppLambdaDemo10 {
    public void run() {
        SomeFuncInterface10<String> reverse = (str) -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }

            return result;
        };

        System.out.println("Lambda rev to " + reverse.func("LamBDA"));
        System.out.println("Lambda rev to " + reverse.func("LamLamTo"));

        SomeFuncInterface10<Integer> factorial = (num) -> {
            int result = 1;

            for (int i = 1; i <= num; i++) {
                result = i * result;
            }

            return result;
        };

        System.out.println("Factorial 5 is " + factorial.func(5));
        System.out.println("Factorial 10 is " + factorial.func(10));
    }
}
