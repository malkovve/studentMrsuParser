package parser;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface Parser {
    List<? extends Object> parse(File file) throws FileNotFoundException, XMLStreamException;
}
