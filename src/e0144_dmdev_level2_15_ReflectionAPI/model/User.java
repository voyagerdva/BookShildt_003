package e0144_dmdev_level2_15_ReflectionAPI.model;

import jdk.jfr.Period;

import java.io.Serializable;

public class User extends Person implements Serializable, Comparable<User> {
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Long id, String name) {
        super(id);
        this.name = name;
    }

    public User(Long id) {
        super(id);
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }


}
