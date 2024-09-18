package FinalDSA;

import java.util.Arrays;

public class Knapsack {
    private int id;
    private int capacity;
    private Item[] items;

    /**
     * Constructs a new Knapsack
     * @param id unique identifier of the Knapsack
     * @param capacity maximum capacity of the Knapsack; must be at least 1
     * @param items array of Items that could be put into the Knapsack; must not be null and have at least one Item
     */
    public Knapsack(int id, int capacity, Item[] items) {
        if (capacity < 1) throw new IllegalArgumentException("capacity must be at least 1");
        if (items == null || items.length == 0) throw new IllegalArgumentException("items must be an array with at least one item");
        this.id = id;
        this.capacity = capacity;
        this.items = items;
    }

    /**
     * Returns the maximum capacity of this Knapsack
     * @return capacity of the Knapsack
     */
    public int getCapacity() {return capacity;}

    /**
     * Returns the array of Items that could be put into the Knapsack
     * @return array of Items that could be put in the Knapsack
     */
    public Item[] getItems() {return items;}

    /**
     * Returns the id of the Knapsack
     * @return the id of the Knapsack
     */
    public int getId() {return id;}

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("ID: ");
        ret.append(getId());
        ret.append(", Capacity: ");
        ret.append(getCapacity());
        ret.append(", Items: ");
        ret.append(Arrays.toString(items));
        ret.append("\n");
        return ret.toString();
    }
}


