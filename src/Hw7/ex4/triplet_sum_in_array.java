package Hw7.ex4;
import java.util.Scanner;
import java.util.Arrays;
public class triplet_sum_in_array {
    public static boolean find3Numbers(int[] arr, int n, int X) {
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == X) {
                    return true;
                } else if (sum < X) {
                    left++;
                } else {
                    right--;
                }
            }
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
        System.out.print("Enter X: ");
        int X = sc.nextInt();

        if (find3Numbers(arr, n, X)) {
            //return 1 if there's a triplet in the array which sums up to the given integer X
            System.out.println(1);
        } else {
            //return 0 if not
            System.out.println(0);
        }
    }
}
