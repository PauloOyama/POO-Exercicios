package Visitor;

import java.util.List;

public class MulVisitor implements NumberVisitor{
    @Override
    public void visit(TwoElement twoElement) {
        int mul = twoElement.a * twoElement.b;
        System.out.println(twoElement.a + " * " + twoElement.b + " = " + mul);
    }

    @Override
    public void visit(ThreeElements threeElement) {
        int mul = threeElement.a * threeElement.b * threeElement.c;
        System.out.println(threeElement.a + " * " + threeElement.b + " * " + threeElement.c + " = " + mul);
    }

    @Override
    public void visit(List<NumberElement> elementList) {
        for (NumberElement ne : elementList){
            ne.accept(this);
        }
    }
}
