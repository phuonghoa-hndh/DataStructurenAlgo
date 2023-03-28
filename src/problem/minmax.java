package problem;

import java.util.*;
public class minmax {
    public static int[] findMinMax(int[] arr, int left, int right) {
        int[] result = new int[2];
        int min, max, mid;
        // Array has 1 element
        if (left == right) {
            result[0] = arr[left];
            result[1] = arr[left];
            return result;
        }
        /// Array has 2 element
        if (right == left + 1) {
            if (arr[left] > arr[right]) {
                result[0] = arr[right];
                result[1] = arr[left];
            } else {
                result[0] = arr[left];
                result[1] = arr[right];
            }
            return result;
        }
        mid = (left + right) / 2;
        int[] leftResult = findMinMax(arr, left, mid);
        int[] rightResult = findMinMax(arr, mid + 1, right);
        if (leftResult[0] < rightResult[0]) {
            min = leftResult[0];
        } else {
            min = rightResult[0];
        }
        if (leftResult[1] > rightResult[1]) {
            max = leftResult[1];
        } else {
            max = rightResult[1];
        }
        result[0] = min;
        result[1] = max;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt(n);

        int[] result = findMinMax(arr, 0, n - 1);
        System.out.println("Minimum element is: " + result[0]);
        System.out.println("Maximum element is: " + result[1]);
    }
}
