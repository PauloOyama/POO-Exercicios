package Visitor;

import java.util.List;

public interface NumberVisitor {

    public void visit(TwoElement twoElement);
    public void visit(ThreeElements threeElement);
    public void visit(List<NumberElement> elementList);
}
