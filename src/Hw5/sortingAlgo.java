package Hw5;

import java.util.Arrays;
import java.util.Random;

public class sortingAlgo {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
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
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int step = 0; step < n; step++) {
            int min = step;

            for (int i = step + 1; i < n; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
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
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
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

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        /* Create temporary arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[middle + 1 + j];
        }

        /* Merge the temporary arrays */
        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }


    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000000) + 1;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] array = generateRandomArray(10000);

        int[] bubbleSortArray = Arrays.copyOf(array, array.length);
        long bubbleSortStartTime = System.currentTimeMillis();
        bubbleSort(bubbleSortArray);
        long bubbleSortEndTime = System.currentTimeMillis();
        long bubbleSortExecutionTime = bubbleSortEndTime - bubbleSortStartTime;

        int[] insertionSortArray = Arrays.copyOf(array, array.length);
        long insertionSortStartTime = System.currentTimeMillis();
        insertionSort(insertionSortArray);
        long insertionSortEndTime = System.currentTimeMillis();
        long insertionSortExecutionTime = insertionSortEndTime - insertionSortStartTime;

        int[] selectionSortArray = Arrays.copyOf(array, array.length);
        long selectionSortStartTime = System.currentTimeMillis();
        selectionSort(selectionSortArray);
        long selectionSortEndTime = System.currentTimeMillis();
        long selectionSortExecutionTime = selectionSortEndTime - selectionSortStartTime;

        int[] heapSortArray = Arrays.copyOf(array, array.length);
        long heapSortStartTime = System.currentTimeMillis();
        heapSort(heapSortArray);
        long heapSortEndTime = System.currentTimeMillis();
        long heapSortExecutionTime = heapSortEndTime - heapSortStartTime;

        int[] quickSortArray = Arrays.copyOf(array, array.length);
        long quickSortStartTime = System.currentTimeMillis();
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        long quickSortEndTime = System.currentTimeMillis();
        long quickSortExecutionTime = quickSortEndTime - quickSortStartTime;

        int[] mergeSortArray = Arrays.copyOf(array, array.length);
        long mergeSortStartTime = System.currentTimeMillis();
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        long mergeSortEndTime = System.currentTimeMillis();
        long mergeSortExecutionTime = mergeSortEndTime - mergeSortStartTime;

        System.out.println("Bubble Sort Execution Time: " + bubbleSortExecutionTime + "ms");
        System.out.println("Insertion Sort Execution Time: " + insertionSortExecutionTime + "ms");
        System.out.println("Selection Sort Execution Time: " + selectionSortExecutionTime + "ms");
        System.out.println("Heap Sort Execution Time: " + heapSortExecutionTime + "ms");
        System.out.println("Quick Sort Execution Time: " + quickSortExecutionTime + "ms");
        System.out.println("Merge Sort Execution Time: " + mergeSortExecutionTime + "ms");
    }

}
