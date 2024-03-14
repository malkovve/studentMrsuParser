package parseInfo;

public class Address {
    private Integer id, floor;
    private String city, street, house, flatNumber;

    public Address (Integer id, String city, String street, String house, Integer floor, String flatNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
        this.flatNumber = flatNumber;
    }

    public Integer getId() { return id;}

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public int getFloor() {
        return floor;
    }

    public String getFlatNumber() {
        return  flatNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Address data = (Address) obj;
        return city.equals(data.city) && street.equals(data.street) && house.equals(data.house) &&
                floor.equals(data.floor) && flatNumber.equals(data.flatNumber);
    }
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + house.hashCode();
        result = 31 * result + floor.hashCode();
        result = 31 * result + flatNumber.hashCode();
        return result;
    }
}
