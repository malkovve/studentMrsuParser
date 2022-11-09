package parser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class XMLParser implements Parser {

    @Override
    public void parse(File file) {

    }

//     todo дополнить реализацию, это чисто пример
    private List<? extends Object> readAddress(File file) {
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
                Adress adresses = new Address();
                if (event == XMLStreamConstants.START_ELEMENT) {
//                    todo: добавить реализацию
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
