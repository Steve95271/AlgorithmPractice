package Algorithms.GraphAlgorithms.Graph_Old_ver;

import java.util.List;

public class TestFloydWarshall {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");

        v1.edges = List.of(new Edge(v3, -2));
        v2.edges = List.of(new Edge(v1, 4), new Edge(v3, 3), new Edge(v4, 6));
        v3.edges = List.of(new Edge(v4, 2));
        v4.edges = List.of(new Edge(v2, -1));

        List<Vertex> graph = List.of(v1, v2, v3, v4);

        FloydWarshall.floydWarshall(graph);
    }
}
