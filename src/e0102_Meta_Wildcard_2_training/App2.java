package e0102_Meta_Wildcard_2_training;


class A {//===========================================================================================
    <T, V> boolean meth(T t, V v) {
        return t == v;
    }
}


class B<T extends Number, V> { //=====================================================================
    T t = null;
    V v = null;

    boolean meth1(T t1, V v1) {
        return t1 == v1;
    }

    int meth2(A a1) {
        return 5;
    }

    void meth3(B<?, ?> b, C<?, ?> c) {

    }

    <T> void meth4() {

    }
}


class C<T extends B<?,?>, V> {   }//===================================================================



//######################################################################################

public class App2 {
    public void run() {

        //=== class A: ====================================
        A a = new A();
        Double a1 = 1.0;
        Integer a2 = 1;
        a.<Number, Number>meth(a1, a2);

        //=== class B: ====================================

        B<Double, Integer> b1 = new B<>();
        b1.meth1(4.0, 7);

        B<Double, Integer> b2 = new B();
        b2.<Integer, Integer>meth2(a);

        boolean b = b2 instanceof B<?, ?>;

        B<?, ?>[] list = new B<?, ?>[10];

        //=== class C: ====================================

        C<B<Number, ?>, ?> c = new C<>();

    }
}
