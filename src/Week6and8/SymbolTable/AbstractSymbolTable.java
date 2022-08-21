package Week6and8.SymbolTable;

public abstract class AbstractSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    public boolean contains(Key key) {
        return get(key) != null;
    }
    public void delete(Key key) {
        put(key, null);
    }
}
