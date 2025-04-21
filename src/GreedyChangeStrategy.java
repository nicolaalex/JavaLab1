/**
 * Implements the ChangeStrategy interface using a greedy algorithm.
 * Selects the largest possible denomination at each step to make change
 * for a given amount. Assume denominations are given in descending order.
 */


public class GreedyChangeStrategy implements ChangeStrategy {
    @Override
    public Purse makeChange(double amount, Denomination[] denominations) {
        Purse purse = new Purse();
        for (Denomination d : denominations) {
            while (amount >= d.amt() - 0.0001) {
                purse.add(d, 1);
                amount -= d.amt();
            }
        }
        return purse;
    }
}
