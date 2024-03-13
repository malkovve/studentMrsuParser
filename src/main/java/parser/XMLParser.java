package parser;

import parseInfo.Address;
import parseInfo.Client;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser implements Parser {

    @Override
    public List<?> parse(File file) {
         return readFile(file);
    }

    private List<?> readFile(File file) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }

        List<Object> listFile = new ArrayList<>();

        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if (parser.getLocalName().equals("address")) {
                        Integer id = Integer.valueOf(parser.getAttributeValue(null, "id"));
                        String city = parser.getAttributeValue(null, "city");
                        String street = parser.getAttributeValue(null, "street");
                        String house = parser.getAttributeValue(null, "house");
                        Integer floor = Integer.valueOf(parser.getAttributeValue(null, "floor"));
                        String flatNumber = parser.getAttributeValue(null, "flatNumber");
                        listFile.add(new Address(id, city, street, house, floor, flatNumber));
                    }
                    if (parser.getLocalName().equals("client")) {
                        Integer id = Integer.valueOf(parser.getAttributeValue(null, "id"));
                        String name = parser.getAttributeValue(null, "name");
                        String personnelNumber = parser.getAttributeValue(null, "personnelNumber");
                        Integer addressId = Integer.valueOf(parser.getAttributeValue(null, "addressId"));
                        listFile.add(new Client(id, name, personnelNumber, addressId));
                    }
                }
            }

        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        return listFile;
    }
}