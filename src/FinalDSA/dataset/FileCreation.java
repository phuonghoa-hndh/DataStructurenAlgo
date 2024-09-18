package FinalDSA.dataset;

import java.io.*;
import java.util.Random;

public class FileCreation {
    /** Upper bound for weights and values (exclusive)*/
    private static final int MAX = 201;
    /** Lower bound for weights and values (inclusive) */
    private static final int MIN = 1;

    /** Private constructor to prevent instantiation */
    private FileCreation() {}

    /**
     * Creates the files inputs4-6.csv
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int knapsackNum = 4;
        for (int cap = 20; cap <= 30; cap += 5) {
            createFile(cap, knapsackNum++);
        }
    }

    //create file 20: input4.csv, 4, 20 /n random ints between 1 and 200 /n same
    //create file 25: input5.csv, 5, 25, /n 25 random ints, 25 random ints
    //create file 30: input6.csv, 6, 30, /n 30 random ints, 30 random int

    /**
     * Creates a new Knapsack file named inputsX.csv with capacity random weights and benefits
     * @param capacity the capacity of the Knapsack; must be at least 1 to proceed
     * @param knapsackNum the number of the Knapsack, must be 4 or more (to avoid overwriting provided files) to proceed
     * @return whether the file was successfully created or not
     */
    public static boolean createFile(int capacity, int knapsackNum) {
        if (knapsackNum < 4 || capacity < 1) return false;
        System.out.println();
        File file = new File("src/KnapsackItems/inputs" + knapsackNum + ".csv");
//        System.out.println("---" + file.getAbsolutePath());
        try {
            //delete if already exists
            file.delete();
            //so you can make a new one
            file.createNewFile();
            //write to file
            PrintStream d = new PrintStream(file);
            //knapsack number and capacity
            d.print(knapsackNum);
            d.print(',');
            d.print(capacity);
            d.print(',');
            d.print('\n');
            //values line, then weights line
            Random r = new Random();
            for (int line = 0; line < 2; line++) {
                d.print(r.nextInt(MIN, MAX));
                for (int i = 2; i <= capacity; i++) {
                    d.print(',');
                    d.print(r.nextInt(MIN, MAX));
                }
                d.print('\n');
            }
            d.close();
            return true;
        } catch (Exception e) {return false;}
    }
}
