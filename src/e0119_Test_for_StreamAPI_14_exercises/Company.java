package e0119_Test_for_StreamAPI_14_exercises;

import java.util.List;

class Company {
    Address19 address;
    String name;
    List<String> productIdList; // список продуктов которые покупает компания

    public Company(Address19 address, String name, List<String> productIdList) {
        this.address = address;
        this.name = name;
        this.productIdList = productIdList;
    }
}
