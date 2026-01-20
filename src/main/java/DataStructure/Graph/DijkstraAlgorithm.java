package DataStructure.Graph;

import java.util.ArrayList;
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

    private static void dijkstra(Vertex source) {
        PriorityQueue<Vertex> minHeap = new PriorityQueue<>(Comparator.comparingInt(Vertex::getDistance));
        source.setDistance(0);
        minHeap.add(source);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap);
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
