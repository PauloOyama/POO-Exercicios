package Normal;

public class Demo {

    public static void main(String args[]){
        TwoElement two1 = new TwoElement(2,3);
        TwoElement two2 = new TwoElement(3,3);
        ThreeElement three1 = new ThreeElement(3,4,5);

        Sentences sent = new Sentences();
        sent.addOperation(two1);
        sent.addOperation(two2);
        sent.addOperation(three1);

        sent.showSums();
        sent.showTotalSum();


        sent.showMuls();
        sent.showTotalMul();
    }

}
