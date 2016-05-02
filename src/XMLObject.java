/**
 * Created by ted on 5/1/16.
 */
abstract class XMLObject {
    protected String text;
    protected XMLComposite container;

    XMLObject() {}

    void accept(IXMLObjectVisitor visitor) {

    }
}
