package Hw7.ex1;

import java.util.ArrayList;
import java.util.List;

public class LinkedListSymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value> {
    private Node first;
    private int n = 0;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void put(Key key, Value value) {
        if (value == null) {
            delete(key); // Remove the key if null value is provided
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value; // Update the existing value
                return;
            }
        }
        first = new Node(key, value, first); // Insert new node at the beginning
        n++;
    }

    @Override
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty(Key key) {
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> list = new ArrayList<>();
        for (Node x = first; x != null; x = x.next) {
            list.add(x.key);
        }
        return list;
    }
}


