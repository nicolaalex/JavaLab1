// PURSE CLASS

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

// Contains the amount into the fewest possible coins and bills
public class Purse {

    private final Map<denomination, Integer> cash = new LinkedHashMap <denomination, Integer>();

    // adds the number of the denomination
    public void add(denomination type, int num){
        // if no val for key, then add 1
        if (!cash.containsKey(type)){
            cash.put(type, num);
        }

        // else add one to current val
        else {
            cash.put(type, cash.get(type) + num);
        }




    }

    // diminishes money in the purse and returns the amount removed
    public double remove (denomination type, int num){

    // current count of denomination
    int current_amt = cash.get(type);

    // verifies if there is enough money to remove
    if (current_amt < num)    {
        System.out.println("There is not enough" + type.name() + " to remove.");
    }

    // removes the amount then update the map
    double remove_amt = type.amt() * num;
    cash.put(type, current_amt - num);
    return remove_amt;
}

// returns the amount of money in the Purse
    public double getValue(){

        // multiples amount of demoniation by count; returns total
        double total = 0;

        for (denomination funds : cash.keySet()) {

            total = total + cash.get(funds) + funds.amt();

        }
        return total;

    }

    // returns a string representation of the Purse and its contents


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (cash.isEmpty())
            return "Purse is Empty";

        // iterates through the map
        for(HashMap.Entry<denomination, Integer> entry : cash.entrySet()){
            result.append((entry.getValue())).append(" ").append(entry.getKey().name()).append(" ");

        }

        return result.toString();

    }
}
