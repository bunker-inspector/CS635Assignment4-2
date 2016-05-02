/**
 * Created by ted on 5/1/16.
 */
public class Text extends XMLObject {
    Text(String s) {
        text = s;
    }

    void accept(IXMLObjectVisitor visitor) {
        visitor.visit(this);
    }
}
