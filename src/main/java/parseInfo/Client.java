package parseInfo;

public class Client {
    private Integer id, addressId;
    private String name, personnelNumber;

    public Client (Integer id, String name, String personnelNumber, Integer addressId) {
        this.id = id;
        this.name = name;
        this.personnelNumber = personnelNumber;
        this.addressId = addressId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPersonnelNumber() {
        return personnelNumber;
    }

    public Integer getAddressId() {
        return addressId;
    }
}
