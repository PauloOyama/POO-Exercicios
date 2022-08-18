package Normal;

public class TwoElement extends Operation {

    int a;
    int b;

    public TwoElement(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int Sum() {
        return a + b;
    }

    @Override
    public int Mul() {
        return a * b;
    }
}
