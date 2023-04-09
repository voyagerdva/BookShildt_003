package e0102_Meta_Wildcard_2_training;

class E<T> {  }

public interface InterfaceD<T extends E<?>> {
    E<?> meth(E<?> t);
}

class D implements InterfaceD<E<?>> {
    @Override
    public E<?> meth(E<?> t) {
        return new E<>();
    }
}
