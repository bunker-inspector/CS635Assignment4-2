/**
 * Created by ted on 5/1/16.
 */
public class PrintHTMLVisitor implements IXMLObjectVisitor {
    @Override
    public void visit(Document document) {
        System.out.print("<CS635Document>" + document.text);

        System.out.println("</CS635Document>");
    }

    @Override
    public void visit(Header header) {
        System.out.print("<header>");
        System.out.println("</header>");
    }

    @Override
    public void visit(Text text) {
        System.out.print("<text>");
        System.out.println("</text>");
    }
}
