package Visitor;

import java.util.List;

public class TotalSumVisitor implements NumberVisitor{

    private int totalSum = 0;
    @Override
    public void visit(TwoElement twoElement) {
        int sum = twoElement.a + twoElement.b;
        System.out.println("Adding " + twoElement.a + " + " + twoElement.b + " = " + sum + " to total.");
        totalSum += sum;
    }

    @Override
    public void visit(ThreeElements threeElement) {
        int sum = threeElement.a + threeElement.b + threeElement.c;
        System.out.println("Adding " + threeElement.a + " + " + threeElement.b + " + " + threeElement.c + " = " + sum + " to total.");
        totalSum += sum;
    }

    @Override
    public void visit(List<NumberElement> elementList) {
        for (NumberElement ne : elementList){
            ne.accept(this);
        }
    }

    public int getTotalSum(){
        return this.totalSum;
    }
}
