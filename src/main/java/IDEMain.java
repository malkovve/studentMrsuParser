import comparator.AddressComparator;
import parseInfo.Address;
import parseInfo.Client;
import parser.XMLParser;

import java.io.File;
import java.util.*;


public class IDEMain {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
        List<Address> addressList = (List<Address>) xmlParser.parse(new File("address.xml"));
        List<Client> clientList = (List<Client>) xmlParser.parse(new File("client.xml"));

        System.out.print("Print all address:\n");
        for (Address address : addressList)
            System.out.printf("id: %s, City: %s, Street: %s, House: %s, Floor: %s, FlatNumber: %s%n",
                    address.getId(), address.getCity(), address.getStreet(), address.getHouse(), address.getFloor(), address.getFlatNumber());

        System.out.print("\nPrint all client:\n");
        for (Client client : clientList)
            System.out.printf("id: %s, Name: %s, PersonnelNumber: %s, AddressId: %s%n",
                    client.getId(), client.getName(), client.getPersonnelNumber(), client.getAddressId());

        AddressComparator comparator = new AddressComparator();
        Set<Address> addressListDuble = comparator.AddressComparator(addressList);
        System.out.print("\nPrint duble address:\n");
        for (Address address : addressListDuble)
            System.out.printf("id: %s, City: %s, Street: %s, House: %s, Floor: %s, FlatNumber: %s%n",
                    address.getId(), address.getCity(), address.getStreet(), address.getHouse(), address.getFloor(), address.getFlatNumber());

        System.out.printf("\nPrint count duble address: %d\n", addressListDuble.size());

        System.out.print("\nPrint count clients by floor:\n");
        List<String> countPeople =  countPeople(addressList, clientList);
        for (String countPrint : countPeople)
            System.out.printf(countPrint + "%n");

    }

    public static List<String> countPeople(List<Address> addr, List<Client> client) {
        Map<Integer, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (Client clientList : client) {
            for(Address addressList : addr) {
                if (clientList.getAddressId().equals(addressList.getId())) {
                    map.put(addressList.getFloor(), map.getOrDefault(addressList.getFloor(), 0) + 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add("Floor: " + entry.getKey() + ", count Client: " + entry.getValue());
        }

        return result;
    }
}
