package e0124_JavaCore_Object_clone_Math;

public class TestClone24 implements Cloneable{
    int a;
    double b;

    TestClone24 cloneTest() {
        try {
            return (TestClone24) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Клонирование невозможно");
            e.printStackTrace();
            return this;
        }

    }

}
