package Hw5;

public class UnsortedLinkedPriorityQueue <K extends Comparable,E> implements PriorityQueueInterface{
    protected class NodeEntry<K, E> implements Entry<K, E>{
        private K key;
        private E element;
        private NodeEntry<K, E> next;
        public NodeEntry (K k, E e){
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
    private NodeEntry<K,E> head;
    private NodeEntry<K,E> tail;
    int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public void insert(Entry entry) {
        if(isEmpty()){
            head = (NodeEntry<K, E>) entry;
            tail = (NodeEntry<K, E>) entry;
        }
        else{
            tail.setNext((NodeEntry<K, E>) entry);
            tail = (NodeEntry<K, E>) entry;
        }
        n++;
    }

    @Override
    public void insert(Object o, Object o2) {

        NodeEntry<K,E> entry = new NodeEntry<K,E>((K) o,(E) o2);
        if(isEmpty()){
            head = entry;
            tail = entry;
        }
        else{
            tail.setNext(entry);
            tail = entry;
        }
        n++;
    }

    @Override
    public Entry removeMin() {
        if(isEmpty()) {
            n--;
            return null;
        }
        if(size()==1){
            NodeEntry<K,E> temp = head;
            head = null;
            tail = null;
            n--;
            return temp;
        }
        n--;
        NodeEntry<K,E> min = head;
        NodeEntry<K,E> minPrev = null;
        NodeEntry<K,E> prev = null;
        NodeEntry<K,E> current = head;
        while(current!=null){
            if(current.getKey().compareTo(min.getKey())<0){
                min = current;
                minPrev = prev;
            }
            prev = current;
            current = current.getNext();
        }
        if(minPrev==null){
            head = head.getNext();
        }else if(min==tail){
            tail = minPrev;
            minPrev.setNext(null);
        }
        else{
            minPrev.setNext(min.getNext());
        }
        return min;
    }

    @Override
    public Entry min() {
        if(isEmpty()) return null;
        NodeEntry<K,E> min = head;
        NodeEntry<K,E> current = head;
        while(current!=null){
            if(current.getKey().compareTo(min.getKey())<0){
                min = current;
            }
            current = current.getNext();
        }
        return min;
    }
}
