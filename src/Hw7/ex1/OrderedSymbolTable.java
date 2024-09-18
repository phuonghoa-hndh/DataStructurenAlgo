package Hw7.ex1;

public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {
    Key min();

    Key max();

    Key floor(Key key);

    Key ceiling(Key key);

    int rank(Key key);

    Key select(int k);

    void deleteMin();

    void deleteMax();

    int size(Key u, Key v);

    Iterable<Key> keys(Key u, Key v);
}
