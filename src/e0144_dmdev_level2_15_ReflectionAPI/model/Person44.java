package e0144_dmdev_level2_15_ReflectionAPI.model;

public abstract class Person44 {
    private Long id;

    public Long getId() {
        return id;
    }

    public Person44(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }


}
