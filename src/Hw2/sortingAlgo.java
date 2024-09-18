package Hw2;

import java.util.*;

public class sortingAlgo {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // i and j are the elements in array
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; //optimize
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
                if (!swapped)
                    break;
            }
            System.out.println("Bubble Sort - Iteration " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int step = 0; step < n; step++) {
            int min = step; //choose the 1st element as min element

            for (int i = step + 1; i < n; i++) {
                if (arr[i] < arr[min]) {
                    min = i; //replace the element which less than min
                }
            }

            int temp = arr[step];
            arr[step] = arr[min];
            arr[min] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; //choose the 1nd element as key element
            int j = i - 1;
            while (j >= 0 && arr[j] > key) { //Compare key with the first element
                arr[j + 1] = arr[j];
                j = j - 1;
                //If the 1st element is greater than key, then key is placed in front of the first element.
            }
            arr[j + 1] = key;
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    //generate random numbers
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000000) + 1;
        }
        return arr;
    }

//    public static void evaluateSortingAlgorithm(SortingAlgorithm algorithm, int[] array) {
//        long startTime = System.currentTimeMillis();
//        SortingStats stats = algorithm.sort(array.clone());
//        long endTime = System.currentTimeMillis();
//        long executionTime = endTime - startTime;
//
//        System.out.println("Total comparisons: " + stats.getComparisons());
//        System.out.println("Total swaps: " + stats.getSwaps());
//        System.out.println("Execution time: " + executionTime + " milliseconds\n");
//    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        for (int size : sizes) {
            System.out.println("Array size: " + size);
            int[] arr = generateRandomArray(size);
            System.out.println("Array: " + Arrays.toString(arr));

            int[] arrCopy1 = Arrays.copyOf(arr, arr.length);
            System.out.println("Bubble Sort:");
            bubbleSort(arrCopy1);

            int[] arrCopy2 = Arrays.copyOf(arr, arr.length);
            System.out.println("Selection Sort:");
            selectionSort(arrCopy2);

            int[] arrCopy3 = Arrays.copyOf(arr, arr.length);
            System.out.println("Insertion Sort:");
            insertionSort(arrCopy3);

            int[] arrCopy4 = Arrays.copyOf(arr, arr.length);
            System.out.println("Quick Sort:");
            quickSort(arrCopy4, 0, arrCopy4.length - 1);
            System.out.println("Quick Sort: " + Arrays.toString(arrCopy4) + "\n");
        }
    }
}
