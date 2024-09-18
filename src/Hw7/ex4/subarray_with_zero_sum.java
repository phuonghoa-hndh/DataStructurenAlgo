package Hw7.ex4;
import java.util.HashSet;
import java.util.Scanner;

public class subarray_with_zero_sum {
    public static boolean subarrayWithZeroSum(int[] arr) {
        HashSet<Integer> prefixSums = new HashSet<>();
        int currentSum = 0;

        for (int num : arr) {
            currentSum += num;

            if (currentSum == 0 || prefixSums.contains(currentSum)) {
                return true;
            }

            prefixSums.add(currentSum);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements in array: ");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("The " + (i + 1) + " element: ");
            arr[i] = sc.nextInt();
        }


        if (subarrayWithZeroSum(arr)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
