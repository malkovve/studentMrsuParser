package parser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser /*implements Parser*/ {
    private ArrayList<Address> addresses = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    public void parse(File file) {
        readAddress(file);
        if (!clients.isEmpty()) {
            for (Client client : clients) {
                System.out.println(client);
            }
        } else for (Address address : addresses) {
            System.out.println(address);
        }
    }

    //     todo дополнить реализацию, это чисто пример
    private void readAddress(File file) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }

        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("address")) {
                        int id = Integer.parseInt(parser.getAttributeValue(0));
                        String city = parser.getAttributeValue(1);
                        String street = parser.getAttributeValue(2);
                        int house = Integer.parseInt(parser.getAttributeValue(3));
                        int floor = Integer.parseInt(parser.getAttributeValue(4));
                        int flatNumber = Integer.parseInt(parser.getAttributeValue(5));
                        Address address = new Address(id, city, street, house, floor, flatNumber);
                        addresses.add(address);
                    }
                    if (parser.getLocalName().equals("client")) {
                        int id = Integer.parseInt(parser.getAttributeValue(0));
                        String name = parser.getAttributeValue(1);
                        String personalNumber = parser.getAttributeValue(2);
                        int addressId = Integer.parseInt(parser.getAttributeValue(3));
                        Address address = addresses.get(addressId - 1);
                        Client client = new Client(id, name, personalNumber, address);
                        clients.add(client);
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
    }
}
