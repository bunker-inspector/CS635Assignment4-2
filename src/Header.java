/**
 * Created by ted on 5/1/16.
 */
public class Header extends XMLObject {
    Header(String s) {
        text = s;
    }

    void accept(IXMLObjectVisitor visitor) {
        visitor.visit(this);
    }
}
