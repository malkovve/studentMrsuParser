public class Address {
    private int id;           // идентификатор
    private String city;         // город
    private String street;       // улица
    private int house;        // дом
    private int floor;        // этаж
    private int flatNumber;   // квартира
    private ArrayList<Address> addresses;

    public Address(int id, String city, String street, int house, int floor, int flatNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
    }

    public Adress() {
        addresses = new Address();
    }
}
