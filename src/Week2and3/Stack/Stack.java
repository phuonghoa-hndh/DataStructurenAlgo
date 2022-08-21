package Week2and3.Stack;

public interface Stack<E> {
    public void push(E data);
    public E pop();
    public boolean isEmpty();
    public int size();
}