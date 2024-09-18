package Hw8;

public class Edge<E> {
    private E element;
    private Vertex<?> u;
    private Vertex<?> v;

    public Edge(E element, Vertex<?> u, Vertex<?> v) {
        this.element = element;
        this.u = u;
        this.v = v;
    }

    public E getElement() {
        return element;
    }

    public Vertex<?>[] getEndpoints() {
        return new Vertex<?>[] { u, v };
    }
}
