package e0127_dmdev_level2_11_Serialization;

import java.io.Serializable;

public class Person27 implements Serializable {
    private int age;
    private transient String firstName;

    public Person27(int age, String firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }

    @Override
    public String toString() {
        return "Person27{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                '}';
    }

}
