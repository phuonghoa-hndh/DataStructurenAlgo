package Hw8;

public class TestMain {
    public static void main(String[] args) {
        Graph<String, Integer> graph = new AdjacencyMatrixGraph<>(5);

        Vertex<String> v0 = graph.insertVertex("A");
        Vertex<String> v1 = graph.insertVertex("B");
        Vertex<String> v2 = graph.insertVertex("C");
        Vertex<String> v3 = graph.insertVertex("D");
        Vertex<String> v4 = graph.insertVertex("E");

        graph.insertEdge(v0, v1, 52);
        graph.insertEdge(v0, v2, 39);
        graph.insertEdge(v1, v2, 28);
        graph.insertEdge(v1, v3, 64);
        graph.insertEdge(v2, v3, 71);
        graph.insertEdge(v2, v4, 40);
        graph.insertEdge(v3, v4, 23);

        System.out.println("Graph adjacency matrix:");
        graph.printGraph();

        System.out.println("Number of vertices: " + graph.numVertices());

        System.out.println("Number of edges: " + graph.numEdges());

        System.out.println("Out-degree of vertex B: " + graph.outDegree(v1));
        System.out.println("In-degree of vertex B: " + graph.inDegree(v1));

        System.out.println("Edge between B and D: " + (graph.getEdge(v1, v3) != null ? "exists" : "does not exist"));

        System.out.print("Vertices adjacent to vertex C: ");
        for (Edge<Integer> edge : graph.outgoingEdges(v2)) {
            Vertex<?>[] endpoints = edge.getEndpoints();
            Vertex<?> opposite = endpoints[0] == v2 ? endpoints[1] : endpoints[0];
            System.out.print(opposite.getElement() + " ");
        }
        System.out.println();

        System.out.print("Edges adjacent to vertex C: ");
        for (Edge<Integer> edge : graph.outgoingEdges(v2)) {
            System.out.print("(" + edge.getEndpoints()[0].getElement() + ", " + edge.getEndpoints()[1].getElement() + ", " + edge.getElement() + ") ");
        }
        System.out.println();
    }
}

