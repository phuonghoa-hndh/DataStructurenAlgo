package Week1.Sorting;

import java.util.Scanner;

public class InsertionSort {
    public static void Ascending(int array[]) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i-1;
            while (j >= 0 && key < array[j]) {
                array[j+1] = array[j];
                --j;
            }
            array[j+1] = key;
        }
        for (int i = 0; i < n; i++)
            System.out.println(array[i]);
    }

    public static void Descending(int array[]) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i-1;
            while (j >= 0 && key > array[j]) {
                array[j+1] = array[j];
                --j;
            }
            array[j+1] = key;
        }
        for (int i = 0; i < n; i++)
            System.out.println(array[i]);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        int [] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the value of all items: ");
            array[i] = sc.nextInt();
        }
        System.out.println("Sorted Array in Ascending Order:");
        InsertionSort.Ascending(array);
        System.out.println("Sorted Array in Descending Order:");
        InsertionSort.Descending(array);
    }
}
