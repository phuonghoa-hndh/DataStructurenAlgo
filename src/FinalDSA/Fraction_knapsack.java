package FinalDSA;

import java.util.Arrays;
import FinalDSA.*;

public class Fraction_knapsack {
    private final double value;

    public Fraction_knapsack(Knapsack knapsack) {
        this.value = solveFractionalKnapsack(knapsack);
    }


    public static double solveFractionalKnapsack(Knapsack knapsack) {
        Item[] items = knapsack.getItems();
        int capacity = knapsack.getCapacity();

        //sort the items in descending order based on their value-to-weight ratio
        Arrays.sort(items); //here is quicksort

        double totalBenefit = 0.0;

        for (Item item : items) {
            if (capacity <= 0) {
                break;
            }

            //Adding whole item to knapsack
            if (item.getWeight() <= capacity) {
                totalBenefit += item.getBenefit();
                capacity -= item.getWeight();
            } else {
                //Take a fraction of the item to fill remaining capacity
                double fraction = (double) capacity / item.getWeight();
                totalBenefit += fraction * item.getBenefit();
                capacity = 0;
                break;
            }
        }
        return totalBenefit;
    }

    public double getValue() {
        return value;
    }
}
