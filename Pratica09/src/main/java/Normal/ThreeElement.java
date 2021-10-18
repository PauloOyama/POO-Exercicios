package Normal;

public class ThreeElement extends Operation{

    private int a;
    private int b;
    private int c;

    public ThreeElement(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int Sum() {
        return (a + b + c);
    }

    @Override
    public int Mul() {
        return (a * b * c);
    }

}
