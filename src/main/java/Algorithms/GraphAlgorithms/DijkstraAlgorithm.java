package Algorithms.GraphAlgorithms;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.addEdge(List.of(new Edge(v3, 9), new Edge(v2, 7), new Edge(v6, 14)));
        v2.addEdge(List.of(new Edge(v4, 15)));
        v3.addEdge(List.of(new Edge(v4, 11), new Edge(v6, 2)));
        v4.addEdge(List.of(new Edge(v5, 6)));
        v6.addEdge(List.of(new Edge(v5, 9)));

        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6);

        dijkstra(v1);

        graph.forEach(g ->
                System.out.println(
                        g.getName() + " " + g.getDistance() + ", prev: " + (g.prev != null ? g.prev.getName() : "null")
                )
        );
    }

    /*
    * 迪克斯特拉单源最短路径算法
    *   - 选择一个当前距离最短的顶点
    *   - 遍历当前顶点的所有边
    *   - 用当前顶点的距离加上边的权重（距离），如果小于此边链接顶点的距离则更新链接顶点的距离
    *   - 重复以上步骤直到所有顶点都处理完成
    *       - 一个顶点在遍历完它的所有边并处理好它和链接的顶点的距离后算处理完成
    *
    * NOTICE: 迪克斯特拉算法无法处理有负边的情况，所有边的权重都需要大于或等于零
    * */

    private static void dijkstra(Vertex source) {
        PriorityQueue<Vertex> minHeap = new PriorityQueue<>(Comparator.comparingInt(Vertex::getDistance));
        source.setDistance(0);
        minHeap.add(source);

        while (!minHeap.isEmpty()) {
            System.out.println("Min heap: " + minHeap);
            // Choose the vertex which has the smallest distance
            Vertex currentVertex = minHeap.poll();
            // Skip if already visited
            if (currentVertex.isVisited()) continue;
            // Set visited
            currentVertex.setVisited();

            // Update the current vertex's neighbours distance
            currentVertex.getEdges().forEach(e -> {
                // Get current edge's linked vertex
                Vertex linkedVertex = e.getLinkedVertex();
                // Update distance only not yet visited
                if (!linkedVertex.isVisited()) {
                    int dist = currentVertex.getDistance() +  e.getWeight();
                    // Only update distance when shorter
                    if (dist < linkedVertex.getDistance()) {
                        linkedVertex.setDistance(dist);
                        linkedVertex.prev = currentVertex;
                        minHeap.add(linkedVertex);
                    }
                }
            });

        }
    }

}
