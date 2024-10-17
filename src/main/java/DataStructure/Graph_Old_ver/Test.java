package DataStructure.Graph_Old_ver;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(
                new Edge(v6, 14),
                new Edge(v2, 7),
                new Edge(v3, 9)
        );

        v6.edges = List.of(
                new Edge(v5, 9)
        );

        v2.edges = List.of(
                new Edge(v4, 15)
        );

        v3.edges = List.of(
                new Edge(v6, 2),
                new Edge(v4, 11)
        );

        v4.edges = List.of(
                new Edge(v5, 6)
        );

        v5.edges = List.of();

        //new Dfs().dfs(v1);

        System.out.println("------------------------");

        //new Bfs().bfs(v1);

        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6);

        new Dijkstra().dijkstra(graph, v1);
    }
}
