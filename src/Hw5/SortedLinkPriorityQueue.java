package Hw5;

public class SortedLinkPriorityQueue<K extends Comparable,E>
        implements PriorityQueueInterface {
    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            key = k;
            element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }

        public NodeEntry<K, E> getNext() {
            return next;
        }

        public void setNext(NodeEntry<K, E> next) {
            this.next = next;
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;


    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry entry) {
        if (isEmpty()) {
            head = (NodeEntry<K, E>) entry;
            tail = (NodeEntry<K, E>) entry;
            n++;
            return;
        }
        n++;
        NodeEntry<K, E> current = head;
        NodeEntry<K, E> previous = null;
        while (current != null) {
            if (current.getKey().compareTo((K) entry.getKey()) > 0) {
                if (previous == null) {
                    head = (NodeEntry<K, E>) entry;
                    ((NodeEntry<K, E>) entry).setNext(current);
                    return;
                }
                previous.setNext((NodeEntry<K, E>) entry);
                ((NodeEntry<K, E>) entry).setNext(current);
                return;
            }
            previous = current;
            current = current.getNext();
        }
        previous.setNext((NodeEntry<K, E>) entry);
        tail = (NodeEntry<K, E>) entry;
    }

    @Override
    public void insert(Object o, Object o2) {
        NodeEntry<K, E> entry = new NodeEntry<K, E>((K) o, (E) o2);
        if (isEmpty()) {
            head = entry;
            tail = entry;
            n++;
            return;
        }
        n++;
        NodeEntry<K, E> current = head;
        NodeEntry<K, E> previous = null;
        while (current != null) {
            if (current.getKey().compareTo((K) o) > 0) {
                if (previous == null) {
                    head = entry;
                    entry.setNext(current);
                    return;
                }
                previous.setNext(entry);
                entry.setNext(current);
                return;
            }
            previous = current;
            current = current.getNext();
        }
        previous.setNext(entry);
        tail = entry;
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) return null;
        n--;
        NodeEntry min = head;
        head = head.getNext();
        return min;
    }

    @Override
    public Entry min() {
        return head;
    }
}

