package e0112_Lambda_10_lambda_and_exception;

import e0112_Lambda_10_lambda_and_exception_2.DoubleNumArrayInterface122;
import e0112_Lambda_10_lambda_and_exception_2.EmptyArrayException122;

public class AppLambdaDemo12 {
    public void run() throws EmptyArrayException122 {
        Double[] values = {1.0, 2.0, 3.0, 4.0};

        DoubleNumArrayInterface122<Double, Double[]> average = n -> {
            double sum = 0;

            if (n.length == 0) {
                throw new EmptyArrayException122();
            }

            for (int i = 0; i < n.length; i++) {
                sum += n[i];
            }

            return (double) sum / n.length;
        };

        System.out.println("Aver is: " + average.func(values));

        System.out.println("Aver is:" + average.func(new Double[0]));
    }
}
