package e0144_dmdev_level2_15_ReflectionAPI.model;

import java.io.Serializable;

public class User44 extends Person44 implements Serializable, Comparable<User44> {
    private String name;

    public User44(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     @Override
    public int compareTo(User44 o) {
        return 0;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
