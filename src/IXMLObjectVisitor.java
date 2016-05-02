/**
 * Created by ted on 5/1/16.
 */
public interface IXMLObjectVisitor {
    void visit(Document document);
    void visit(Header header);
    void visit(Text text);
}
