public class DraconianKingdomFactory implements  KingdomFactory{
    @Override
    public Castle createCastle() {
        return new DraconianCastle();
    }

    @Override
    public King createKing() {
        return new DraconianKing();
    }

    @Override
    public Army createArmy() {
        return new DraconianArmy();
    }

    @Override
    public Wizard createWizard() {
        return new DraconianWizard();
    }
}
