import java.util.LinkedHashMap;
import java.util.HashMap;

public class Purse {
    LinkedHashMap<Denomination, Integer> cash = new LinkedHashMap<>();

    public void add(Denomination money, int num) {
        cash.put(money, cash.getOrDefault(money, 0) + num);
    }

    public double getValue() {
        double total = 0;
        for (Denomination d : cash.keySet()) {
            total += cash.get(d) * d.amt();
        }
        return total;
    }

    @Override
    public String toString() {
        if (cash.isEmpty()) return "This Purse is Empty";
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Denomination, Integer> entry : cash.entrySet()) {
            sb.append(entry.getValue()).append(" ").append(entry.getKey().name()).append("\n");
        }
        return sb.toString();
    }
}
