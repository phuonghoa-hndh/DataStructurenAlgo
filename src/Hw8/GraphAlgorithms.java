package Hw8;

import java.util.*;

//this is excercise 4
public class GraphAlgorithms<V, E> {

    // Depth-First Search
    public void DFS(Graph<V, E> graph, Vertex<V> start) {
        Set<Vertex<V>> visited = new HashSet<>();
        DFSHelper(graph, start, visited);
    }

    private void DFSHelper(Graph<V, E> graph, Vertex<V> v, Set<Vertex<V>> visited) {
        visited.add(v);
        System.out.print(v.getElement() + " ");
        for (Edge<E> edge : graph.outgoingEdges(v)) {
            Vertex<V> opposite = graph.opposite(v, edge);
            if (!visited.contains(opposite)) {
                DFSHelper(graph, opposite, visited);
            }
        }
    }

    // Breadth-First Search
    public void BFS(Graph<V, E> graph, Vertex<V> start) {
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            System.out.print(v.getElement() + " ");
            for (Edge<E> edge : graph.outgoingEdges(v)) {
                Vertex<V> opposite = graph.opposite(v, edge);
                if (!visited.contains(opposite)) {
                    visited.add(opposite);
                    queue.add(opposite);
                }
            }
        }
    }

    // Dijkstra's Algorithm
    public Map<Vertex<V>, Integer> dijkstra(Graph<V, Integer> graph, Vertex<V> source) {
        Map<Vertex<V>, Integer> distances = new HashMap<>();
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparing(distances::get));
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

        for (Vertex<V> v : graph.vertices()) {
            distances.put(v, Integer.MAX_VALUE);
            pq.add(v);
        }
        distances.put(source, 0);

        while (!pq.isEmpty()) {
            Vertex<V> u = pq.poll();
            for (Edge<Integer> edge : graph.outgoingEdges(u)) {
                Vertex<V> v = graph.opposite(u, edge);
                int alt = distances.get(u) + edge.getElement();
                if (alt < distances.get(v)) {
                    pq.remove(v);
                    distances.put(v, alt);
                    previous.put(v, u);
                    pq.add(v);
                }
            }
        }
        return distances;
    }

    // Hamiltonian Path and Cycle
    public boolean hamiltonianCycle(Graph<V, E> graph, Vertex<V> start) {
        List<Vertex<V>> path = new ArrayList<>();
        path.add(start);
        return hamiltonianCycleHelper(graph, start, path) && path.size() == graph.numVertices();
    }

    private boolean hamiltonianCycleHelper(Graph<V, E> graph, Vertex<V> v, List<Vertex<V>> path) {
        if (path.size() == graph.numVertices()) {
            return graph.getEdge(path.get(path.size() - 1), path.get(0)) != null;
        }
        for (Edge<E> edge : graph.outgoingEdges(v)) {
            Vertex<V> opposite = graph.opposite(v, edge);
            if (!path.contains(opposite)) {
                path.add(opposite);
                if (hamiltonianCycleHelper(graph, opposite, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    // Eulerian Path and Cycle
    public boolean isEulerianCycle(Graph<V, E> graph) {
        for (Vertex<V> v : graph.vertices()) {
            if (graph.outDegree(v) != graph.inDegree(v)) {
                return false;
            }
        }
        return isConnected(graph);
    }

    private boolean isConnected(Graph<V, E> graph) {
        Set<Vertex<V>> visited = new HashSet<>();
        DFS(graph, graph.vertices().iterator().next(), visited);
        return visited.size() == graph.numVertices();
    }

    private void DFS(Graph<V, E> graph, Vertex<V> start, Set<Vertex<V>> visited) {
        visited.add(start);
        for (Edge<E> edge : graph.outgoingEdges(start)) {
            Vertex<V> opposite = graph.opposite(start, edge);
            if (!visited.contains(opposite)) {
                DFS(graph, opposite, visited);
            }
        }
    }

    // Minimum Spanning Tree (Prim's Algorithm)
    public Graph<V, E> primMST(Graph<V, E> graph) {
        Set<Vertex<V>> inMST = new HashSet<>();
        PriorityQueue<Edge<E>> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> (Integer) edge.getElement()));
        Vertex<V> start = graph.vertices().iterator().next();
        inMST.add(start);

        for (Edge<E> edge : graph.outgoingEdges(start)) {
            pq.add(edge);
        }

        Graph<V, E> mst = new AdjacencyMatrixGraph<>(graph.numVertices());

        while (!pq.isEmpty()) {
            Edge<E> edge = pq.poll();
            Vertex<V>[] endpoints = (Vertex<V>[]) edge.getEndpoints();
            Vertex<V> u = endpoints[0];
            Vertex<V> v = endpoints[1];
            if (inMST.contains(u) && !inMST.contains(v)) {
                mst.insertVertex(v.getElement());
                mst.insertEdge(u, v, edge.getElement());
                inMST.add(v);
                for (Edge<E> nextEdge : graph.outgoingEdges(v)) {
                    if (!inMST.contains(graph.opposite(v, nextEdge))) {
                        pq.add(nextEdge);
                    }
                }
            } else if (!inMST.contains(u) && inMST.contains(v)) {
                mst.insertVertex(u.getElement());
                mst.insertEdge(u, v, edge.getElement());
                inMST.add(u);
                for (Edge<E> nextEdge : graph.outgoingEdges(u)) {
                    if (!inMST.contains(graph.opposite(u, nextEdge))) {
                        pq.add(nextEdge);
                    }
                }
            }
        }
        return mst;
    }

    // Minimum Spanning Tree (Kruskal's Algorithm)
    public Graph<V, E> kruskalMST(Graph<V, E> graph) {
        PriorityQueue<Edge<E>> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> (Integer) edge.getElement()));
        pq.addAll((Collection<? extends Edge<E>>) graph.edges());

        Graph<V, E> mst = new AdjacencyMatrixGraph<>(graph.numVertices());
        Map<Vertex<V>, Vertex<V>> parent = new HashMap<>();
        for (Vertex<V> v : graph.vertices()) {
            mst.insertVertex(v.getElement());
            parent.put(v, v);
        }

        while (!pq.isEmpty() && mst.numEdges() < graph.numVertices() - 1) {
            Edge<E> edge = pq.poll();
            Vertex<V>[] endpoints = (Vertex<V>[]) edge.getEndpoints();
            Vertex<V> u = endpoints[0];
            Vertex<V> v = endpoints[1];
            Vertex<V> rootU = find(parent, u);
            Vertex<V> rootV = find(parent, v);
            if (!rootU.equals(rootV)) {
                mst.insertEdge(u, v, edge.getElement());
                union(parent, rootU, rootV);
            }
        }
        return mst;
    }

    private Vertex<V> find(Map<Vertex<V>, Vertex<V>> parent, Vertex<V> vertex) {
        if (!parent.get(vertex).equals(vertex)) {
            parent.put(vertex, find(parent, parent.get(vertex)));
        }
        return parent.get(vertex);
    }

    private void union(Map<Vertex<V>, Vertex<V>> parent, Vertex<V> u, Vertex<V> v) {
        Vertex<V> rootU = find(parent, u);
        Vertex<V> rootV = find(parent, v);
        parent.put(rootU, rootV);
    }

    // Graph Coloring
    public int graphColoring(Graph<V, E> graph) {
        Map<Vertex<V>, Integer> colors = new HashMap<>();
        int maxColor = 0;

        for (Vertex<V> v : graph.vertices()) {
            Set<Integer> usedColors = new HashSet<>();
            for (Edge<E> edge : graph.outgoingEdges(v)) {
                Vertex<V> opposite = graph.opposite(v, edge);
                if (colors.containsKey(opposite)) {
                    usedColors.add(colors.get(opposite));
                }
            }
            int color = 1;
            while (usedColors.contains(color)) {
                color++;
            }
            colors.put(v, color);
            if (color > maxColor) {
                maxColor = color;
            }
        }
        return maxColor;
    }

    // Test function
    public static void main(String[] args) {
        GraphAlgorithms<String, Integer> algorithms = new GraphAlgorithms<>();
        Graph<String, Integer> graph = new AdjacencyMatrixGraph<>(5);

        Vertex<String> v0 = graph.insertVertex("A");
        Vertex<String> v1 = graph.insertVertex("B");
        Vertex<String> v2 = graph.insertVertex("C");
        Vertex<String> v3 = graph.insertVertex("D");
        Vertex<String> v4 = graph.insertVertex("E");

        graph.insertEdge(v0, v1, 56);
        graph.insertEdge(v0, v2, 39);
        graph.insertEdge(v1, v2, 24);
        graph.insertEdge(v1, v3, 67);
        graph.insertEdge(v2, v3, 72);
        graph.insertEdge(v2, v4, 45);
        graph.insertEdge(v3, v4, 20);

        System.out.println("DFS from A:");
        algorithms.DFS(graph, v0);

        System.out.println("\nBFS from A:");
        algorithms.BFS(graph, v0);

        System.out.println("\nDijkstra from A:");
        Map<Vertex<String>, Integer> distances = algorithms.dijkstra(graph, v0);
        for (Map.Entry<Vertex<String>, Integer> entry : distances.entrySet()) {
            System.out.println("Distance to " + entry.getKey().getElement() + ": " + entry.getValue());
        }

        System.out.println("\nHamiltonian Cycle starting from A: " + algorithms.hamiltonianCycle(graph, v0));

        System.out.println("\nIs Eulerian Cycle: " + algorithms.isEulerianCycle(graph));

        System.out.println("\nPrim's MST:");
        Graph<String, Integer> mstPrim = algorithms.primMST(graph);
        for (Edge<Integer> edge : mstPrim.edges()) {
            System.out.println(edge.getEndpoints()[0].getElement() + " - " + edge.getEndpoints()[1].getElement() + ": " + edge.getElement());
        }

        System.out.println("\nKruskal's MST:");
        Graph<String, Integer> mstKruskal = algorithms.kruskalMST(graph);
        for (Edge<Integer> edge : mstKruskal.edges()) {
            System.out.println(edge.getEndpoints()[0].getElement() + " - " + edge.getEndpoints()[1].getElement() + ": " + edge.getElement());
        }

        System.out.println("\nGraph Coloring:");
        int numColors = algorithms.graphColoring(graph);
        System.out.println("Number of colors: " + numColors);
    }
}

