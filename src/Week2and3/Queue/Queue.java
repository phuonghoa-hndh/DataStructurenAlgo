package Week2and3.Queue;

interface Queue<E> {
    void enqueue(E data);
    E dequeue();
    boolean isEmpty();
    int size();
}
