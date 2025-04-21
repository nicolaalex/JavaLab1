public class Register {
    private final Denomination[] denominations;
    private final ChangeStrategy strategy;

    public Register(ChangeStrategy strategy) {
        this.strategy = strategy;
        this.denominations = DenominationFactory.getStandardUSDenominations();
    }

    public Purse makeChange(double amt) {
        return strategy.makeChange(amt, denominations);
    }
}
