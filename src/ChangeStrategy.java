// determine how to make change given an amount and available denominations


public interface ChangeStrategy {
    Purse makeChange(double amount, Denomination[] denominations);
}
