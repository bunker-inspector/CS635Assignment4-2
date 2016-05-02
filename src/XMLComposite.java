import java.util.Vector;

/**
 * Created by ted on 5/1/16.
 */
public class XMLComposite {
    XMLObject value;
    Vector<XMLComposite> children;

    XMLComposite(XMLObject o) {
        value = o;
        children = new Vector<>();
    }

    void addElement(XMLComposite x) {
        children.addElement(x);
    }
}
