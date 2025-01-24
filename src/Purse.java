
// returns the purse that contains the least bills and coins
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Purse {
    // map of denomination
    LinkedHashMap<Denomination, Integer> cash = new LinkedHashMap<Denomination,Integer>();

    //Adds number of the denomination
    public void add(Denomination money_type, int num) {
        // if there is no value for the key then  add 1
        if (!cash.containsKey(money_type)) {
            cash.put(money_type, num);
        }
        // else add one to the current value
        else {
            cash.put(money_type, cash.get(money_type) + num);
        }


    }
    // diminish money in purse and returns amount that was removed
    public double remove(Denomination money_type, int num) {
        //Current count of denomination
        int current_count = cash.get(money_type);

        // verifies if there is enough money to remove
        if (current_count < num) {
            System.out.println("There is not enough " + money_type.name() + " to remove.");
            return 0;
        }
        //removes and updates the map
        double removed_amt = money_type.amt()*num;
        cash.put(money_type,current_count-num);
        return removed_amt;
    }

    // returns the amount of money in the purse
    public double getValue() {
        // multiply amount of denomination by count
        double total = 0;
        for (Denomination money : cash.keySet()) {
            total += cash.get(money) * money.amt();
        }
        return total;
    }

    // returns a string representation of the Purse and its contents
    public String toString() {
        String result = "";
        // verifies if purse is  empty or not
        if (cash.isEmpty())
            return "This Purse is Empty";

        //iterate through map
        for (HashMap.Entry<Denomination, Integer> entry : cash.entrySet()) {
            result += (entry.getValue()) + (" ") + (entry.getKey().name()) + ("\n");
        }
        return result;

    }

}
