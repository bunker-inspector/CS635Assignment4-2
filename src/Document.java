import javax.print.Doc;

/**
 * Created by ted on 5/1/16.
 */
public class Document extends XMLObject {
    Document(String s) {
        text = s;
    }

    void accept(IXMLObjectVisitor visitor) {
        visitor.visit(this);
    }
}
