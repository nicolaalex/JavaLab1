// Register class: Manages the denominations and provides functionality to calculate change.

public class Register {
    private DenominationFactory denominationFactory;

    // Constructor that initializes the denomination factory
    public Register() {
        denominationFactory = new DenominationFactory();
    }

    // Make change based on the provided amount using the strategy pattern.
    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        Denomination[] denominations = denominationFactory.createDenominations();

        // Strategy: Find the minimum number of denominations to make change.
        for (Denomination denomination : denominations) {
            while (amt >= denomination.amt()) {
                purse.add(denomination, 1);
                amt -= denomination.amt();
            }
        }
        return purse;
    }
}
