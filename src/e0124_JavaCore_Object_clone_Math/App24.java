package e0124_JavaCore_Object_clone_Math;

public class App24 {
    public void run() {
        TestClone24 x1 = new TestClone24();
        TestClone24 x2;

        x1.a = 10;
        x1.b = 20.98;

        x2 = x1.cloneTest();

        System.out.println("x1: " + x1.a + " " + x1.b);
        System.out.println("x2: " + x2.a + " " + x2.b);
    }
}
