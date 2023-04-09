package e0120_TestApiStream_2_my_test_some_functions_in_StreamAPI;


public class User001 {
    long id;
    String firstName;
    String lastName;
    int age;
    String nationality;

    User001(long id, String fN, String lN, int age, String nationality) {
        this.id = id;
        this.firstName = fN;
        this.lastName = lN;
        this.age = age;
        this.nationality = nationality;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}