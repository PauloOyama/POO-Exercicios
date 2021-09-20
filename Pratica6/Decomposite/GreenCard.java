package Decorator;

public class GreenCard extends ChristmasCard{

    private final ChristmasCard card;
    //A Green Christmas Card representing the fertility of a new year
    public GreenCard(ChristmasCard card){
        this.card = card;
    }

    @Override
    public String getDescription() {
        return card.getDescription() + ", as the tree grows";
    }
}
