package Visitor;

public class ThreeElements implements NumberElement{

    final int a;
    final int b;
    final int c;

    public ThreeElements(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void accept(NumberVisitor visitor) {
        visitor.visit(this);
    }
}
