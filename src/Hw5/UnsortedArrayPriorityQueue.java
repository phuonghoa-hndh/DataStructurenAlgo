package Hw5;

public class UnsortedArrayPriorityQueue<K extends Comparable,E> implements PriorityQueueInterface{
    protected class ArrEntry<K,E> implements Entry<K,E>{
        protected K key;
        protected E value;
        public ArrEntry(K k, E e){
            key = k;
            value = e;
        }
        public K getKey(){
            return key;
        }
        public E getValue(){
            return value;
        }
    }
    ArrEntry[] array;
    int n=0;
    int defaultSize = 1000;


    public UnsortedArrayPriorityQueue(){
        array =new ArrEntry[defaultSize];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public void insert(Object o, Object o2) {
        array[n++] = new ArrEntry((K) o,(E) o2);
    }

    @Override
    public void insert(Entry entry) {
        array[n++]= (ArrEntry) entry;
    }

    @Override
    public Entry<K, E> removeMin() {
        if(isEmpty()) return null;
        int min = 0;
        for(int i =0;i<n;i++){
            if(((Comparable)array[i].getKey()).compareTo(array[min].getKey())<0) {
                min = i;
            }
        }
        ArrEntry<K,E> temp = array[min];
        for (int i = min; i < n-1; i++) {
            array[i] = array[i+1];
        }
        n--;
        return  temp;
    }

    @Override
    public Entry<K, E> min() {
        if(isEmpty()) return null;
        int min = 0;
        for(int i =0;i<n;i++){
            if(((Comparable)array[i].getKey()).compareTo(array[min].getKey())<0) {
                min = i;
            }
        }
        return array[min];
    }


}
