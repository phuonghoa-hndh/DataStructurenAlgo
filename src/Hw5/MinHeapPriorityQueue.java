package Hw5;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue {
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

    ArrEntry<K,E> heapPQ[]=new ArrEntry[defaultSize];

    @Override
    public void insert(Entry entry) {
        heapPQ[n] = (ArrEntry<K, E>) entry;
        n++;
        upHeap();
    }

    @Override
    public void insert(Object o, Object o2) {
        ArrEntry<K,E> entry = new ArrEntry<K,E>((K) o,(E) o2);
        heapPQ[n] = entry;
        n++;
        upHeap();
    }

    @Override
    public Entry removeMin() {
        if(isEmpty()) return null;
        ArrEntry<K,E> temp = heapPQ[0];
        heapPQ[0] = heapPQ[n-1];
        n--;
        downHeap();
        return temp;
    }

    @Override
    public Entry min() {
        return heapPQ[0];
    }

    protected void upHeap(){
        int i = n-1;
        while(i>0){
            int p = (i-1)/2;
            if(heapPQ[i].getKey().compareTo(heapPQ[p].getKey())<0){
                ArrEntry<K,E> temp = heapPQ[i];
                heapPQ[i] = heapPQ[p];
                heapPQ[p] = temp;
                i = p;
            }else break;
        }
    }

    protected void downHeap(){
        int i=0;
        while(i<n){
            int c1= 2*i+1;
            int c2= c1+1;
            if(c1>=n) break;
            if(c1==n-1) c2=c1;
            int min = heapPQ[c1].getKey().compareTo(heapPQ[c2].getKey())<0?c1:c2;
            if(heapPQ[i].getKey().compareTo(heapPQ[min].getKey())>0){
                ArrEntry<K,E> temp = heapPQ[i];
                heapPQ[i] = heapPQ[min];
                heapPQ[min] = temp;
                i = min;
            }else break;
        }
    }
}
