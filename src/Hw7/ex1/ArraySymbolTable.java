package Hw7.ex1;

import java.util.Arrays;

public class ArraySymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int n = 0;

    public ArraySymbolTable() {
        keys = (Key[]) new Comparable[10]; // Initial capacity
        values = (Value[]) new Object[10];
    }

    private void resize(int capacity) {
        Key[] tempKeys = (Key[]) new Comparable[capacity];
        Value[] tempValues = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempKeys[i] = keys[i];
            tempValues[i] = values[i];
        }
        keys = tempKeys;
        values = tempValues;
    }

    public void put(Key key, Value value) {
        if (value == null) {
            delete(key);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        if (n == keys.length)
            resize(2 * keys.length);
        keys[n] = key;
        values[n] = value;
        n++;
    }

    public Value get(Key key) {
        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty(Key key) {
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Iterable<Key> keys() {
        return Arrays.asList(Arrays.copyOf(keys, n));
    }
}
