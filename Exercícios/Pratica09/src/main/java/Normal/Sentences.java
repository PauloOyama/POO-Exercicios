package Normal;

import java.util.ArrayList;

public class Sentences {

    ArrayList<Operation> sent = new ArrayList<Operation>();


    public void showSums(){
        for (Operation num : sent) {
            System.out.println("A soma resultante eh = " + num.Sum() );
        }
    }

    public void showMuls(){
        for (Operation num : sent) {
            System.out.println("A multiplicacao resultande eh = " + num.Mul() );
        }
    }

    public void showTotalSum(){
        int total = 0;
        for (Operation num : sent) {
            total += num.Sum();
        }
        System.out.println("A soma total eh = " + total);
    }

    public void showTotalMul(){
        int total = 0;
        for (Operation num : sent) {
            total += num.Mul();
        }
        System.out.println("A multiplicacao total eh = " + total);
    }

    public void addOperation(Operation op){
        sent.add(op);
    }
}
