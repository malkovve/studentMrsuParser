package parser;

import java.util.ArrayList;

public class Address {
    private int id;           // идентификатор
    private String city;         // город
    private String street;       // улица
    private int house;        // дом
    private int floor;        // этаж
    private int flatNumber;   // квартира

    public Address(int id, String city, String street, int house, int floor, int flatNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
        this.flatNumber = flatNumber;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", floor=" + floor +
                ", flatNumber=" + flatNumber;
    }
}
