package Week1.Sorting;

import java.util.Scanner;

public class SelectionSort {
    public static void Ascending(int array[]) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
           int min = 1;
           for (int j = i+1; j < n; j++){
               if (array[j] < array[min]) {
                   min = j;
               }
           }
           int temp = array[i];
           array[i] = array[min];
           array[min] = temp;
        }
        for (int i = 0; i < n; i++)
            System.out.println(array[i]);
    }

    public static void Descending(int array[]) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int min = 1;
            for (int j = i+1; j < n; j++){
                if (array[j] > array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
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
        SelectionSort.Ascending(array);
        System.out.println("Sorted Array in Descending Order:");
        SelectionSort.Descending(array);
    }
}
