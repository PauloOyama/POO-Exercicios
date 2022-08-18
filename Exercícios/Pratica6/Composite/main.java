package Compositor;

public class main {

    public static void main(String[] args){
        /* 0 */
        ExpressaoAritmetica ex1 = new Numero(0);
        System.out.println(ex1.getResultado());

        /* 1 + 2 */
        ExpressaoAritmetica ex2 = new Operacao(Operacao.Operacoes.SUM, new Numero(1), new Numero(2) );
        System.out.println(ex2.getResultado());

        /* 1 * (2 + 3) */
        ExpressaoAritmetica aux0 = new Operacao(Operacao.Operacoes.SUM, new Numero(2), new Numero(3) );
        ExpressaoAritmetica ex3 = new Operacao(Operacao.Operacoes.MUL, new Numero(1), aux0);
        System.out.println(ex3.getResultado());

        /* (2* 3) + (4 /  (5 - 3)) */
        ExpressaoAritmetica aux1 = new Operacao(Operacao.Operacoes.SUB, new Numero(5), new Numero(3) );
        ExpressaoAritmetica aux2 = new Operacao(Operacao.Operacoes.MUL, new Numero(2), new Numero(3) );
        ExpressaoAritmetica aux3 = new Operacao(Operacao.Operacoes.DIV, new Numero(4), aux1 );
        ExpressaoAritmetica ex4 = new Operacao(Operacao.Operacoes.SUM, aux2, aux3);
        System.out.println(ex4.getResultado());
    }
}
