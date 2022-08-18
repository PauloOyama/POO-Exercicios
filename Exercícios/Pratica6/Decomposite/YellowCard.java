package Decorator;

public class YellowCard extends ChristmasCard{

    //Like the sunrise, let this color shine in your eyes!
    private final ChristmasCard card;
    public YellowCard(ChristmasCard card) {
        this.card = card;
    }

    @Override
    public String getDescription() {
        return card.getDescription() + ", like the sunrise";
    }
}
