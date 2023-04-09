package e0113_Lambda_11_cath_var;

public class AppLambdaDemo13 {

    public void run() {

        int num = 10;
        MyFuncInterface13<Integer> myLambda = n -> {
            int v = num + n;
//            num++;
            return v;
        };

        System.out.println(num);
//        num = 9;
    }
}
