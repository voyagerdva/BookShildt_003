package e0115_Lambda_13_Andrey_A_B_C;

public class A15 implements InterfaceA15 {
    public String name;
    public Address15 address;

    A15(String n, Address15 address) {
        this.name = n;
        this.address = address;
    }

    A15() {

    }

    @Override
    public A2_15 get() {
        return new A2_15();
    }

    @Override
    public String get2(String str) {
        return str;
    }

    @Override
    public void set(String s) {
    }

    @Override
    public String get3(C15 c) {
        return c.getString(c.toString());
    }
}
