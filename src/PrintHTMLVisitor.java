/**
 * Created by ted on 5/1/16.
 */
public class PrintHTMLVisitor implements IXMLObjectVisitor {
    @Override
    public void visit(Document document) {
        System.out.print("<CS635Document>" + document.text);

        if(!document.container.children.isEmpty()) {
            for(XMLComposite c : document.container.children) {
                visit(c.value);
            }
        }

        System.out.println("</CS635Document>");
    }

    @Override
    public void visit(Header header) {
        System.out.print("<header>" + header.text);

        if(!header.container.children.isEmpty()) {
            for(XMLComposite c : header.container.children) {
                visit(c.value);
            }
        }

        System.out.println("</header>");
    }

    @Override
    public void visit(Text text) {
        System.out.print("<text>" + text.text);

        if(!text.container.children.isEmpty()) {
            for(XMLComposite c : text.container.children) {
                visit(c.value);
            }
        }

        System.out.println("</text>");
    }

    @Override
    public void visit(XMLObject xmlObject) {
        xmlObject.accept(this);
    }
}
