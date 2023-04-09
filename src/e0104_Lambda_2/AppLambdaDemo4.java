package e0104_Lambda_2;

public class AppLambdaDemo4 {
    public void run() {
        NumTestInterface isEven = (n) -> (n % 2) == 0;

        if (isEven.test(10)) {
            System.out.println("Dig 10 is even");
        }

        if (!isEven.test(9)) {
            System.out.println("Dig 9 is not even");
        }

        NumTestInterface isNonNeg = (n) -> n >= 0;

        if (isNonNeg.test(58)) {
            System.out.println("Dig 58 is positiv");
        }
        if (!isNonNeg.test(-39)) {
            System.out.println("Dig -39 is negativ");
        }

    }
}
