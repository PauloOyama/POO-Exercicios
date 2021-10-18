package Visitor;

import java.util.List;

public class TotalMulVisitor implements NumberVisitor{

    int totalMul;
    @Override
    public void visit(TwoElement twoElement) {
        int mul = twoElement.a * twoElement.b;
        System.out.println("Adding " + twoElement.a + " * " + twoElement.b + " = " + mul + " to total.");
        totalMul += mul;
    }

    @Override
    public void visit(ThreeElements threeElement) {
        int mul = threeElement.a * threeElement.b * threeElement.c;
        System.out.println("Adding " + threeElement.a + " * " + threeElement.b + " * " + threeElement.c + " = " + mul + " to total.");
        totalMul += mul;

    }

    @Override
    public void visit(List<NumberElement> elementList) {
        for (NumberElement ne : elementList){
            ne.accept(this);
        }
    }

    public  int getTotalMul(){
        return this.totalMul;
    }
}
