package e0119_TestApiStream;

public class Address19 {
    String city;
    String street;
    Integer building;

    public Address19(String city, String street, Integer building) {
        this.city = city;
        this.street = street;
        this.building = building;
    }

    public int hashCode () {
        Long h = Long.valueOf(city.length() * 973) + Long.valueOf(street.hashCode()) + Long.valueOf(building.hashCode());
        return h.hashCode();
    }

}
