package Compositor;

public class Operacao extends ExpressaoAritmetica{

    final private Operacoes type;
    private ExpressaoAritmetica op1;
    private ExpressaoAritmetica op2;

    public enum Operacoes {
        SUM, SUB, DIV, MUL
    }

    public Operacao(Operacoes type, ExpressaoAritmetica op1, ExpressaoAritmetica op2) {
        this.type = type;
        this.op1 = op1;
        this.op2 = op2;
    }

    public void setOp1(ExpressaoAritmetica op1) {
        this.op1 = op1;
    }

    public void setOp2(ExpressaoAritmetica op2) {
        this.op2 = op2;
    }

    @Override
    int getResultado() {
        switch (this.type){
            case MUL:
                return op1.getResultado() * op2.getResultado();
            case DIV:
                return op1.getResultado() / op2.getResultado();
            case SUB:
                return op1.getResultado() - op2.getResultado();
            case SUM:
                return op1.getResultado() + op2.getResultado();
            default:
                throw new IllegalArgumentException("Compositor.Operacao nao reconhecida!");
        }
    }
}
