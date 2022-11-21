import parser.XMLParser;

import java.io.File;

public class IDEMain {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
        xmlParser.parse(new File("address.xml"));
        xmlParser.parse(new File("client.xml"));
    }
}
