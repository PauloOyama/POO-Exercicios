package Compositor;

public class Numero extends ExpressaoAritmetica{
    private int valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    @Override
    int getResultado() {
        return valor;
    }

    @Override
    public String toString() {
        return "Compositor.Numero{" +
                "valor=" + valor +
                '}';
    }
}
