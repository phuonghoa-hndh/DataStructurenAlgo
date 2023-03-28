package problem;

import java.util.Random;
import java.util.Scanner;

public class medianArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array 1: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];

        System.out.print("Enter the length of the array 2: ");
        int n2= sc.nextInt();
        int[] arr2 = new int[n2];

        System.out.println("Enter the array1: ");
        for (int i = 0; i < n1; i++)
            arr1[i] = sc.nextInt(n1);

        System.out.println("Enter the array2: ");
        for (int i = 0; i < n2; i++)
            arr2[i] = sc.nextInt(n2);

        int[] merged = new int[n1 + n2];

        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            }
            else {
                merged[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            merged[k++] = arr1[i++];
        }
        while (j < n2) {
            merged[k++] = arr2[j++];
        }
        int mid = (n1 + n2) / 2;
        if ((n1 + n2) % 2 == 0) {
            System.out.println((merged[mid - 1] + merged[mid]) / 2.0);
        }
        else {
            System.out.println(merged[mid]);
        }
        System.out.println("Median of two sorted arrays of different sizes: ");
    }
}
