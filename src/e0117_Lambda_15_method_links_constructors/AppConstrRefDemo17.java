package e0117_Lambda_15_method_links_constructors;

public class AppConstrRefDemo17 {
    <R, T> R myClassFactory(MyFuncInterface17<R, T> constr, T v) {
        return constr.func(v);
    }

    public void run() {
        MyFuncInterface17<MyClass17<Double>, Double> myClassCons = MyClass17<Double>::new;
        MyClass17<Double> mc = myClassFactory(myClassCons, 100.1);
        System.out.println("Value of val in obj mc is:" + mc.getVal());

        MyFuncInterface17<MyClass17_2, String> myClassConstr2 = MyClass17_2::new;
        MyClass17_2 mc2 = myClassFactory(myClassConstr2, "LAMBDA");
        System.out.println("Value of str in obj mc2 is: " + mc2.getVal());
    }
}
