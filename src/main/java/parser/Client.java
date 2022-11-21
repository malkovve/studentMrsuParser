package parser;

public class Client {
    private int id;
    private String name;
    private String personalNumber;
    private Address address;

    public Client(int id, String name, String personalNumber, Address address) {
        this.id = id;
        this.name = name;
        this.personalNumber = personalNumber;
        this.address = address;
    }

    public String toString() {
        return name + " " + personalNumber + " " + address;
    }
}
