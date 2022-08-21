package Week1.Sorting;
import java.util.Scanner;
public class BubbleSort {
        public static void Ascending(int array[]) {
            int n = array.length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n- i - 1; j++)
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
            for (int i = 0; i < n; i++)
                System.out.println(array[i]);
        }
        public static void Descending(int array[]) {
            int n = array.length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n- i - 1; j++)
                    if (array[j] < array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
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
            BubbleSort.Ascending(array);
            System.out.println("Sorted Array in Descending Order:");
            BubbleSort.Descending(array);
        }
    }