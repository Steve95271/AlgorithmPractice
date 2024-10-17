package DataStructure.Graph_Old_ver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FloydWarshall {
    public static void floydWarshall(List<Vertex> graph) {
        int size = graph.size();

        int[][] dist = new int[size][size];
        Vertex[][] prev = new Vertex[size][size];

        //把graph转换成矩阵
        for (int i = 0; i < size; i++) {

            Vertex v = graph.get(i);

            for (int j = 0; j < size; j++) {

                Vertex u = graph.get(j);

                boolean flag = false;

                for (Edge edge : v.edges) {

                    if (v == u) {
                        dist[i][j] = 0;
                    } else if (edge.linkedVertex == u) {
                        dist[i][j] = edge.weight;
                        flag = true;
                    } else if (flag == false) {
                        dist[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        print(dist);
    }

    public static void print(int matrix[][]) {
        System.out.println("--------------");
        for (int[] row : matrix) {
            System.out.println(Arrays.stream(row).boxed().map(x -> x == Integer.MAX_VALUE ? "INF" : String.valueOf(x)).map(s -> String.format("%2s", s)).collect(Collectors.joining(",", "[", "]")));

        }
    }
}


