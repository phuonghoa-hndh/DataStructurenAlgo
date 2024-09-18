package Hw1;
import java.util.*;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        if (n == array.length) {
            resizeArray();
        }
        array[n++] = data;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + i);
        }
        return array[i];
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + i);
        }
        array[i] = data;
    }

    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                System.arraycopy(array, i + 1, array, i, n - i - 1);
                array[--n] = null;
                return;
            }
        }
    }

    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private void resizeArray() {
        T[] newArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < n;
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }
        };
    }
}
