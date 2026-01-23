package Algorithms.GraphAlgorithms;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FloydWarshall {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("V1");
        Vertex v2 = new Vertex("V2");
        Vertex v3 = new Vertex("V3");
        Vertex v4 = new Vertex("V4");

        v1.addEdge(List.of(new Edge(v3, -2)));
        v2.addEdge(List.of(new Edge(v1, 4), new Edge(v3, 3)));
        v3.addEdge(List.of(new Edge(v4, 2)));
        v4.addEdge(List.of(new Edge(v2, -1)));

        List<Vertex> graph = List.of(v1, v2, v3, v4);

        floydWarshall(graph);
    }

    private static void floydWarshall(List<Vertex> graph) {
        int size = graph.size();
        int[][] dist = new int[size][size];
        Vertex[][] prev = new Vertex[size][size];

        // init the dist 2d array
        for (int i = 0; i < size; i++) {
            // grab the vertex at the index and get it's direct linked vertex
            Vertex vertexI = graph.get(i);
            Map<Vertex, Integer> map = vertexI.getEdges().stream().collect(Collectors.toMap(Edge::getLinkedVertex, Edge::getWeight));

            for (int j = 0; j < size; j++) {
                // Set the init distance in the adjacency matrix for the vertex
                Vertex vertexJ = graph.get(j);
                if (vertexJ == vertexI) {
                    dist[i][j] = 0;
                    prev[i][j] = null;
                } else if (map.containsKey(vertexJ)){
                    dist[i][j] = map.get(vertexJ);
                    prev[i][j] = vertexI;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // 检查当前顶点能否通过借助顶点K通往其它顶点
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        int distanceThroughVertexK = dist[i][k] + dist[k][j];
                        // 借助k顶点通往其它顶点的距离更短的时候才更新
                        if (distanceThroughVertexK < dist[i][j]) {
                            dist[i][j] = distanceThroughVertexK;
                            // update the prev vertex
                            prev[i][j] = graph.get(k);
                        }
                    }
                }
            }
            System.out.println("--------------" + "K: " + k + "--------------");
            printPrevArr(prev, graph);
            print2dArr(dist, graph);
        }

        // 检查对角线的值是否有小于零的，如果有说明有负环
        for (int i = 0; i < size; i++) {
            if (dist[i][i] < 0) {
                System.out.println("存在负环");
            }
        }
    }

    private static void print2dArr(int[][] arr, List<Vertex> graph) {
        System.out.println("\n=== Distance Matrix ===");

        // Calculate column width
        int colWidth = 5;
        for (int[] row : arr) {
            for (int val : row) {
                String str = (val == Integer.MAX_VALUE ? "∞" : String.valueOf(val));
                colWidth = Math.max(colWidth, str.length() + 2);
            }
        }

        // Print column headers
        System.out.print(String.format("%" + colWidth + "s", ""));
        for (Vertex v : graph) {
            System.out.print(String.format("%" + colWidth + "s", v.getName()));
        }
        System.out.println();

        // Print separator line
        System.out.println("─".repeat(colWidth * (arr.length + 1)));

        // Print rows with row headers
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("%" + colWidth + "s", graph.get(i).getName()));
            for (int j = 0; j < arr[i].length; j++) {
                String value = (arr[i][j] == Integer.MAX_VALUE ? "∞" : String.valueOf(arr[i][j]));
                System.out.print(String.format("%" + colWidth + "s", value));
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printPrevArr(Vertex[][] prev, List<Vertex> graph) {
        System.out.println("\n=== Predecessor Matrix ===");

        // Calculate column width
        int colWidth = 6;
        for (Vertex[] row : prev) {
            for (Vertex v : row) {
                String str = (v == null ? "─" : v.getName());
                colWidth = Math.max(colWidth, str.length() + 2);
            }
        }

        // Print column headers
        System.out.print(String.format("%" + colWidth + "s", ""));
        for (Vertex v : graph) {
            System.out.print(String.format("%" + colWidth + "s", v.getName()));
        }
        System.out.println();

        // Print separator line
        System.out.println("─".repeat(colWidth * (prev.length + 1)));

        // Print rows with row headers
        for (int i = 0; i < prev.length; i++) {
            System.out.print(String.format("%" + colWidth + "s", graph.get(i).getName()));
            for (int j = 0; j < prev[i].length; j++) {
                String value = (prev[i][j] == null ? "─" : prev[i][j].getName());
                System.out.print(String.format("%" + colWidth + "s", value));
            }
            System.out.println();
        }
        System.out.println();
    }
}
