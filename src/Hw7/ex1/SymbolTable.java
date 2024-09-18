package Hw7.ex1;

public interface SymbolTable<Key extends Comparable<Key>, Value> {
    void put(Key key, Value value);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty(Key key);

    int size();

    Iterable<Key> keys();
}
