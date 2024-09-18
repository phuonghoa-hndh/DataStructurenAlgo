package Hw8;

import java.util.*;

public class AdjacencyMatrixGraph<V, E> implements Graph<V, E> {
    private Map<Vertex<V>, Integer> vertexIndexMap;
    private List<Vertex<V>> vertices;
    private List<Edge<E>> edges;
    public Edge<E>[][] adjacencyMatrix;
    private int numVertices;
    private static final Edge<?> NO_EDGE = null;

    public AdjacencyMatrixGraph(int capacity) {
        vertexIndexMap = new HashMap<>();
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        adjacencyMatrix = new Edge[capacity][capacity];
        numVertices = 0;
    }

    @Override
    public int numVertices() {
        return numVertices;
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return vertices;
    }

    @Override
    public int numEdges() {
        return edges.size();
    }

    @Override
    public Iterable<Edge<E>> edges() {
        return edges;
    }

    @Override
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        int uIndex = vertexIndexMap.get(u);
        int vIndex = vertexIndexMap.get(v);
        return adjacencyMatrix[uIndex][vIndex];
    }

    @Override
    public Vertex<?>[] endVertices(Edge<E> e) {
        return e.getEndpoints();
//        If the graph is directed, the first vertex is the origin and the second is the destination.
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        Vertex<?>[] endpoints = e.getEndpoints();
        if (endpoints[0].equals(v)) {
            return (Vertex<V>) endpoints[1];
        } else if (endpoints[1].equals(v)) {
            return (Vertex<V>) endpoints[0];
        }
        throw new IllegalArgumentException("Edge is not incident to vertex");
    }

    @Override
    public int outDegree(Vertex<V> v) {
        int degree = 0;
        int index = vertexIndexMap.get(v);
        for (Edge<E> edge : adjacencyMatrix[index]) {
            if (edge != NO_EDGE) {
                degree++;
            }
        }
        return degree;
    }

    @Override
    public int inDegree(Vertex<V> v) {
        int degree = 0;
        int index = vertexIndexMap.get(v);
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[i][index] != NO_EDGE) {
                degree++;
            }
        }
        return degree;
//        For an undirected graph, this returns the same value as does outDegree(v).
    }

    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        List<Edge<E>> outgoing = new ArrayList<>();
        int index = vertexIndexMap.get(v);
        for (Edge<E> edge : adjacencyMatrix[index]) {
            if (edge != NO_EDGE) {
                outgoing.add(edge);
            }
        }
        return outgoing;
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
        List<Edge<E>> incoming = new ArrayList<>();
        int index = vertexIndexMap.get(v);
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[i][index] != NO_EDGE) {
                incoming.add(adjacencyMatrix[i][index]);
            }
        }
        return incoming;
//         For an undirected graph, this returns the same collection as does outgoingEdges(v).
    }

    @Override
    public Vertex<V> insertVertex(V x) {
        Vertex<V> v = new Vertex<>(x, numVertices);
        vertexIndexMap.put(v, numVertices);
        vertices.add(v);
        numVertices++;
        return v;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E x) {
        int uIndex = vertexIndexMap.get(u);
        int vIndex = vertexIndexMap.get(v);
        if (adjacencyMatrix[uIndex][vIndex] != NO_EDGE) {
            throw new IllegalArgumentException("Edge already exists");
        }
        Edge<E> edge = new Edge<>(x, u, v);
        adjacencyMatrix[uIndex][vIndex] = edge;
        edges.add(edge);
        return edge;
    }

    @Override
    public void removeVertex(Vertex<V> v) {
        int index = vertexIndexMap.remove(v);
        vertices.remove(v);
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[index][i] != NO_EDGE) {
                edges.remove(adjacencyMatrix[index][i]);
                adjacencyMatrix[index][i] = (Edge<E>) NO_EDGE;
            }
            if (adjacencyMatrix[i][index] != NO_EDGE) {
                edges.remove(adjacencyMatrix[i][index]);
                adjacencyMatrix[i][index] = (Edge<E>) NO_EDGE;
            }
        }
        numVertices--;
    }

    @Override
    public void removeEdge(Edge<E> e) {
        Vertex<?>[] endpoints = e.getEndpoints();
        int uIndex = vertexIndexMap.get(endpoints[0]);
        int vIndex = vertexIndexMap.get(endpoints[1]);
        adjacencyMatrix[uIndex][vIndex] = (Edge<E>) NO_EDGE;
        edges.remove(e);
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == NO_EDGE) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(adjacencyMatrix[i][j].getElement() + " ");
                }
            }
            System.out.println();
        }
    }

}
