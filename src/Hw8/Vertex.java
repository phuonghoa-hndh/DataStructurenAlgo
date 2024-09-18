package Hw8;

public class Vertex<V> {
    private V element;
    private int index;

    public Vertex(V element, int index) {
        this.element = element;
        this.index = index;
    }

    public V getElement() {
        return element;
    }

    public int getIndex() {
        return index;
    }
}



