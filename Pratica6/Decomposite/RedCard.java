package Decorator;

public class RedCard extends ChristmasCard{

    private final ChristmasCard card;

    //A strong color to a strong person!
    public RedCard(ChristmasCard card) {
        this.card = card;
    }

    @Override
    public String getDescription() {
        return card.getDescription() + ", strong for ones";
    }
}
