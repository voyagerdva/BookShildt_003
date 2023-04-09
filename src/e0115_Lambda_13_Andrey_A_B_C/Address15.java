package e0115_Lambda_13_Andrey_A_B_C;

import java.util.ArrayList;
import java.util.List;

public class Address15 {
    public String street;
    public Building15 building;
    public List<String> owners = new ArrayList<>();

    public Address15(String street, Building15 building, List<String> owners) {
        this.street = street;
        this.building = building;
        this.owners = owners;
    }
}
