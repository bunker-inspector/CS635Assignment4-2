/**
 * Created by ted on 5/1/16.
 */
abstract class XMLObject {
    protected String text;

    XMLObject() {}

    void accept(IXMLObjectVisitor visitor) {

    }
}
