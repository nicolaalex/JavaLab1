// Purse class: Stores the denominations and provides methods to add or remove money.
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Purse {
    LinkedHashMap<Denomination, Integer> cash = new LinkedHashMap<>();

    // Adds a denomination to the purse
    public void add(Denomination denomination, int num) {
        cash.put(denomination, cash.getOrDefault(denomination, 0) + num);
    }

    // Removes a denomination from the purse
    public double remove(Denomination denomination, int num) {
        if (cash.getOrDefault(denomination, 0) < num) {
            System.out.println("Not enough " + denomination.name() + " to remove.");
            return 0;
        }
        cash.put(denomination, cash.get(denomination) - num);
        return denomination.amt() * num;
    }

    // Returns the total value in the purse
    public double getValue() {
        double total = 0;
        for (Denomination denomination : cash.keySet()) {
            total += cash.get(denomination) * denomination.amt();
        }
        return total;
    }

    // Returns a string representation of the contents of the purse
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (HashMap.Entry<Denomination, Integer> entry : cash.entrySet()) {
            result.append(entry.getValue()).append(" ").append(entry.getKey().name()).append("\n");
        }
        return result.length() == 0 ? "The purse is empty." : result.toString();
    }
}
