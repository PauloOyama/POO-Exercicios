package Decorator;

public class main {

    public static void main(String[] args){
        ChristmasCard ex1 = new GreenCard(new YellowCard( new RedCard(new ChristmasCard())));
        System.out.println(ex1.getDescription());

        ChristmasCard ex2 = new YellowCard(new YellowCard( new RedCard(new ChristmasCard())));
        System.out.println(ex2.getDescription());

        ChristmasCard ex3 = new GreenCard(new GreenCard( new GreenCard(new ChristmasCard())));
        System.out.println(ex3.getDescription());

        ChristmasCard ex4 = new RedCard(new YellowCard( new GreenCard(new ChristmasCard())));
        System.out.println(ex4.getDescription());

        ChristmasCard ex5 = new GreenCard(new YellowCard( new GreenCard(new ChristmasCard())));
        System.out.println(ex5.getDescription());

    }
}
