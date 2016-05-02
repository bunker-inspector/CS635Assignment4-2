/**
 * Created by ted on 5/1/16.
 */
public class HeaderPrintVisitor implements IXMLObjectVisitor {
    @Override
    public void visit(Document document) {

    }

    @Override
    public void visit(Header header) {
        System.out.println("<header>" + header.text + "</header>");
    }

    @Override
    public void visit(Text text) {

    }

    @Override
    public void visit(XMLObject xmlObject) {
        xmlObject.accept(this);
    }
}
