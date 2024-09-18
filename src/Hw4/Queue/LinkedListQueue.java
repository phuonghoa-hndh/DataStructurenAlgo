package Hw4.Queue;
import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node {
        E element;
        Node next;
    }
    Node queue = null;
    public void enqueue(E element) {
        Node node = new Node();
        node.element = element;
        node.next = queue;
        queue = node;
    }
    public E dequeue() {
        if (queue == null) {
            System.out.println("Empty Queue");
            return null;
        } else {
            E element = queue.element;
            queue = queue.next;
            return element;
        }
    }

    public boolean isEmpty() {
        return queue == null;
    }

    public Iterator<E> iterator() {
        return new QueueIterator();
    }
    class QueueIterator implements Iterator<E> {
        private Node current = queue;
        public boolean hasNext() {
            return current != null;
        }
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }
    }
}
