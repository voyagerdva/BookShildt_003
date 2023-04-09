package e0105_Lambda_3;

public class AppLambdaDemo5 {
    public void run() {
        NumTestInterface5 isFactor = (n, d) -> (n % d) == 0;

        if (isFactor.test(10, 2)) {
            System.out.println("2 is factor of 10");
        }
        if (!isFactor.test(10, 3)) {
            System.out.println("3 is not factor of 10");
        }
    }
}
