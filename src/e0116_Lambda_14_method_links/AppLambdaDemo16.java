package e0116_Lambda_14_method_links;

public class AppLambdaDemo16 {
    static <N> int myOp(MyFuncInterface16<N> f, N[] vals, N v) {
        return f.func(vals, v);
    }

    int count;

    public void runMain() {
        Integer[] vals = {1, 2, 3, 4, 2, 3, 4, 5, 4};
        String[] strs = {"ONE", "TWO", "THREE", "TWO"};



        MyFuncInterface16<? super Integer> isMatch = MyArrayOps::<Integer>countMatching;
        count = myOp(isMatch, vals, 4);
        System.out.println("vals is: " + count + " of dig 4");

        MyFuncInterface16<? super String> isMatch2 = MyArrayOps::<String>countMatching;
        count = myOp(isMatch2, strs, "TWO");
        System.out.println("Strs is: " + count + " of str TWO");
    }

    public void runMain2() {
        MyFuncInterface16_2 myClassCons = MyClass16::new;

        MyClass16 myClass16 = myClassCons.func(100);

        System.out.println("Value VAL in obj myClass16 is: " + myClass16.getVal());
    }

    public void runMain3() {
        MyFuncInterface16_3<Integer> myClassCons3 = MyClass16_3<Integer>::new;
        MyClass16_3<Integer> mc3 = myClassCons3.func(100);
        System.out.println("Value of VAL in obj mc3 is: " + mc3.getVal());

    }
}
