package e0106_Lambda_4_block;

public class AppLambdaDemo6 {
    public void run() {
        NumFuncInterface6 factorial = (n) -> {
            int result = 1;

            for (int i = 1; i <= n; i++) {
                result = i * result;
            }

            return result;
        };

        System.out.println("Factorial is: " + factorial.func(3));
        System.out.println("Factorial is: " + factorial.func(6));

        String s = "asdasdasd";
        System.out.println(s.charAt(5));

    }
}
