package parser;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

public interface Parser {
    void parse(File file) throws FileNotFoundException, XMLStreamException;
}
