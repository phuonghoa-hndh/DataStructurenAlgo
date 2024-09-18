package Hw1;

import java.util.*;

public interface ListInterface<T> extends Iterable<T> {
    public void add(T data);
    public T get(int i);
    public void set(int I, T data);
    public void remove(T data);
//    public void isContain(T data);
    public boolean isContain(T data);
    public int size();
    public boolean isEmpty();
}

