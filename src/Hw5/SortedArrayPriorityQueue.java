package Hw5;

public class SortedArrayPriorityQueue<K extends Comparable, E>
        implements PriorityQueueInterface {
    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
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
    }
    public SortedArrayPriorityQueue(){
        array =new ArrEntry[defaultSize];
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultSize = 1000;

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
        if(isEmpty()){
            array[0] = (ArrEntry<K, E>) entry;
            n++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (array[i].getKey().compareTo(entry.getKey()) < 0) {
                for (int j = n; j > i; j--) {
                    array[j] = array[j - 1];
                }
                array[i] = (ArrEntry<K, E>) entry;
                n++;
                return;
            }
        }
        array[n] = (ArrEntry<K, E>) entry;
        n++;
    }

    @Override
    public void insert(Object o, Object o2) {
        ArrEntry<K, E> entry = new ArrEntry<K, E>((K) o, (E) o2);
        if(isEmpty()){
            array[0] = entry;
            n++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (array[i].getKey().compareTo(entry.getKey()) < 0) {
                for (int j = n; j > i; j--) {
                    array[j] = array[j - 1];
                }
                array[i] = entry;
                n++;
                return;
            }
        }
        array[n] = entry;
        n++;
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) return null;
        return array[--n];
    }

    @Override
    public Entry min() {
        return array[n - 1];
    }
}
