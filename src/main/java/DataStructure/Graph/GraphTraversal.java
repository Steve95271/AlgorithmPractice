package DataStructure.Graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GraphTraversal {
    public static void main(String[] args) {
        System.out.println("Dfs:");
        dfs(getSourceVertex());

        System.out.println("========================");

        System.out.println("Bfs:");
        bfs(getSourceVertex());
    }

    private static Vertex getSourceVertex() {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.addEdge(List.of(
                new Edge(v3, 9),
                new Edge(v2, 7),
                new Edge(v6, 14)
        ));

        v3.addEdge(List.of(
                new Edge(v4, 11),
                new Edge(v6, 2)
        ));

        v2.addEdge(List.of(
                new Edge(v4, 15)
        ));

        v4.addEdge(List.of(
                new Edge(v5, 6)
        ));

        v6.addEdge(List.of(
                new Edge(v5, 9)
        ));

        return v1;
    }

    private static void dfs(Vertex v) {
        System.out.println("Vertex: " + v.getName());
        v.setVisited();
        List<Edge> edges = v.getEdges();

        if (edges == null || edges.isEmpty()) {
            return;
        }


        for (Edge edge : edges) {
            Vertex linkedVertex = edge.getLinkedVertex();
            if (!linkedVertex.isVisited()) {
                dfs(linkedVertex);
            }
        }
    }

    private static void bfs(Vertex v) {
        Deque<Vertex> queue = new LinkedList<>();
        queue.offer(v);
        v.setVisited();

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            System.out.println("Vertex: " + currentVertex.getName());
            for (Edge edge : currentVertex.getEdges()) {
                Vertex linkedVertex = edge.getLinkedVertex();
                if (!linkedVertex.isVisited()) {
                    // 入队前就要标记已访问，不然会出现同一顶点重复入队的问题
                    linkedVertex.setVisited();
                    queue.offer(linkedVertex);
                }
            }
        }
    }

    /*
    * 逻辑错误版本
    *   - 错在出队再标记为已访问
    *   - 会出现顶点重复入队的问题
    * */
    private static void bfs2(Vertex v) {
        Deque<Vertex> queue = new LinkedList<>();
        queue.offer(v);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            currentVertex.setVisited();
            System.out.println("Vertex: " + currentVertex.getName());
            for (Edge edge : currentVertex.getEdges()) {
                Vertex linkedVertex = edge.getLinkedVertex();
                if (!linkedVertex.isVisited()) {
                    queue.offer(linkedVertex);
                }
            }
        }
    }
}
