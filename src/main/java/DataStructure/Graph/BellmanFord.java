package DataStructure.Graph;

import java.util.List;

public class BellmanFord {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("V1");
        Vertex v2 = new Vertex("V2");
        Vertex v3 = new Vertex("V3");
        Vertex v4 = new Vertex("V4");

        v1.addEdge(List.of(new Edge(v2, 2), new Edge(v3, 1)));
        v2.addEdge(List.of(new Edge(v3, -4)));
        v3.addEdge(List.of(new Edge(v1, 1), new Edge(v4, 1)));

        List<Vertex> graph = List.of(v1, v2, v3, v4);

        bellmanFord(graph, v1);
    }

    private static void bellmanFord(List<Vertex> graph, Vertex source) {
        source.setDistance(0);
        int count = 0;
        int size = graph.size();
        // 进行顶点个数减一轮处理
        for (int i = 0; i < size - 1; i++) {
            // 遍历所有的边
            for (Vertex vertex : graph) {
                // 处理每一条边链接的顶点的距离
                for (Edge e : vertex.getEdges()) {
                    Vertex linkedVertex = e.getLinkedVertex();
                    int currentVertexDistance = vertex.getDistance();
                    int linkedVertexDistance = linkedVertex.getDistance();
                    int currentToLinkedDistance = currentVertexDistance + e.getWeight();
                    if (currentVertexDistance != Integer.MAX_VALUE && currentToLinkedDistance < linkedVertexDistance) {
                        linkedVertex.setDistance(currentToLinkedDistance);
                        linkedVertex.prev = vertex;
                    }
                }
            }
        }

        // 多做一轮来判断是否出现负环
        for (Vertex vertex : graph) {
            // 处理每一条边链接的顶点的距离
            for (Edge e : vertex.getEdges()) {
                Vertex linkedVertex = e.getLinkedVertex();
                int currentVertexDistance = vertex.getDistance();
                int linkedVertexDistance = linkedVertex.getDistance();
                int currentToLinkedDistance = currentVertexDistance + e.getWeight();
                if (currentVertexDistance != Integer.MAX_VALUE && currentToLinkedDistance < linkedVertexDistance) {
                    // 如果还能进入这个条件，说明出现负环
                    throw new RuntimeException("Graph has negative ring");
                }
            }
        }

        graph.forEach(v -> System.out.println(v));
    }
}
