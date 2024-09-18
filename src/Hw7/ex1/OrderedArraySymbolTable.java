package Hw7.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderedArraySymbolTable<Key extends Comparable<Key>, Value>
    extends AbstractSymbolTable<Key, Value>
    implements OrderedSymbolTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int n = 0;

    public OrderedArraySymbolTable() {
        keys = (Key[]) new Comparable[10];
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

    public int rank(Key key) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) high = mid - 1;
            else if (cmp > 0) low = mid + 1;
            else return mid;
        }
        return low;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            if (value == null) delete(key);
            else values[i] = value;
            return;
        }
        if (n == keys.length) resize(2 * keys.length);
        for (int j = n; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }

    @Override
    public boolean isEmpty(Key key) {
        return false;
    }

    public Key min() {
        if (isEmpty()) return null;
        return keys[0];
    }

    public Key max() {
        if (isEmpty()) return null;
        return keys[n - 1];
    }

    public Key select(int k) {
        if (k < 0 || k >= n) return null;
        return keys[k];
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i - 1];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        if (i == n) return null;
        else return keys[i];
    }

    public void deleteMin() {
        if (!isEmpty()) delete(keys[0]);
    }

    public void deleteMax() {
        if (!isEmpty()) delete(keys[n - 1]);
    }

    public int size(Key lo, Key hi) {
        if (lo.compareTo(hi) > 0) return 0;
        int rankLo = rank(lo);
        int rankHi = rank(hi);
        if (contains(hi)) return rankHi - rankLo + 1;
        else return rankHi - rankLo;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        List<Key> list = new ArrayList<>();
        if (lo.compareTo(hi) > 0) return list;
        for (int i = rank(lo); i < rank(hi); i++) list.add(keys[i]);
        if (contains(hi)) list.add(keys[rank(hi)]);
        return list;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Iterable<Key> keys() {
        return Arrays.asList(Arrays.copyOf(keys, n));
    }
}

