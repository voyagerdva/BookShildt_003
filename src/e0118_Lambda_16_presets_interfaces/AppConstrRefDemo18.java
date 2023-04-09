package e0118_Lambda_16_presets_interfaces;

import java.util.function.Function;

public class AppConstrRefDemo18 {
    public void run() {
        Function<Integer, Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };

        System.out.println("Factorial of 6 is: " + factorial.apply(6));
        System.out.println("Factorial of 10 is: " + factorial.apply(10));
    }
}
