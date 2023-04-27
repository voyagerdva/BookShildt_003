package e0124_JavaCore_Object_clone_Math;

public class TestClone24_1 implements Cloneable{
    int a;
    double b;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Клонирование невозможно");
            e.printStackTrace();
            return this;
        }

    }

}
