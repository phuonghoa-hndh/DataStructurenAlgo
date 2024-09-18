package Hw2;

import java.util.Arrays;
import java.util.Random;

public class sortingGeneric<T extends Comparable<T>> {
    public void bubbleSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("Bubble Sort - Iteration " + (i+1) + ": " + Arrays.toString(arr));
        }
    }

    public void selectionSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j].compareTo(arr[min_idx]) < 0) {
                    min_idx = j;
                }
            }
            T temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            System.out.println("Selection Sort - Iteration " + (i+1) + ": " + Arrays.toString(arr));
        }
    }

    public void insertionSort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            System.out.println("Insertion Sort - Iteration " + i + ": " + Arrays.toString(arr));
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public T[] genRandomArr(int size, T[] array) {
        Random ran = new Random();
        for (int i = 0; i < size; i++) {
//            array[i] = (T) new Integer(random.nextInt(1000000) + 1);
            array[i] = (T) Integer.valueOf(ran.nextInt(1000000) + 1);

        }
        return array;
    }

    public static void main(String[] args) {
        sortingGeneric<Integer> sortingAlgo = new sortingGeneric<>();
        Integer[] sizes = {100, 1000, 10000, 100000};
        for (Integer size : sizes) {
            System.out.println("Array size: " + size);
            Integer[] array = new Integer[size];
            array = sortingAlgo.genRandomArr(size, array);
            System.out.println("Array: " + Arrays.toString(array));

            Integer[] arrCopy1 = Arrays.copyOf(array, array.length);
            System.out.println("Bubble Sort:");
            sortingAlgo.bubbleSort(arrCopy1);

            Integer[] arrCopy2 = Arrays.copyOf(array, array.length);
            System.out.println("Selection Sort:");
            sortingAlgo.selectionSort(arrCopy2);

            Integer[] arrCopy3 = Arrays.copyOf(array, array.length);
            System.out.println("Insertion Sort:");
            sortingAlgo.insertionSort(arrCopy3);

//            Integer[] arrCopy4 = Arrays.copyOf(array, array.length);
//            System.out.println("Quick Sort:");
//            sortingAlgo.quickSort(arrCopy4);
        }
    }
}
