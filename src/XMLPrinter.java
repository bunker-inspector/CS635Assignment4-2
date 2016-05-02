import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileReader;
import java.util.Stack;

/**
 * Created by ted on 5/1/16.
 */
public class XMLPrinter extends DefaultHandler {
    private XMLComposite root;
    private String recentTag;
    private Stack<XMLComposite> encounterOrder = new Stack<>();

    public XMLPrinter(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            XMLReader xmlr = XMLReaderFactory.createXMLReader();
            xmlr.setContentHandler(this);
            xmlr.setErrorHandler(this);

            FileReader fr = new FileReader(fileName);
            xmlr.parse(new InputSource(fr));
        }
        catch (Throwable t) {}
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        recentTag = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        encounterOrder.pop();
        recentTag = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(recentTag != null) {
            if(root == null) {
                root = xmlCompositeFactory(recentTag, new String(ch, start, length));
                encounterOrder.push(root);
            }
            else {
                XMLComposite newComposite = xmlCompositeFactory(recentTag, new String(ch, start, length));
                encounterOrder.peek().addElement(newComposite);
                encounterOrder.push(newComposite);
            }
        }
    }

    private XMLComposite xmlCompositeFactory(String tag, String value) {
        switch (tag) {
            case "CS635Document":
                return new XMLComposite(new Document(value));
            case "header":
                return new XMLComposite(new Header(value));
            case "text":
                return new XMLComposite(new Text(value));
            default:
                return null;
        }
    }

    public void printHeaders() {
        HeaderPrintVisitor hpv = new HeaderPrintVisitor();
        visitAll(root, hpv);
    }

    public void printHtml() {
        PrintHTMLVisitor phv = new PrintHTMLVisitor();
        visitAll(root, phv);
    }

    private void visitAll(XMLComposite composite, IXMLObjectVisitor visitor) {
        if(composite.children.isEmpty()) {
            composite.value.accept(visitor);
        }
        else {
            composite.value.accept(visitor);
            for(XMLComposite c : composite.children) {
                visitAll(c, visitor);
            }
        }
    }

    public static void main(String[] args) {
        XMLPrinter xmlPrinter = new XMLPrinter("example.xml");
        xmlPrinter.printHtml();
    }
}
