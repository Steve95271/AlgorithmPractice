package DataStructure.Graph;

import java.util.ArrayList;
import java.util.List;

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

        dijkstra(graph, v1);

        graph.forEach(g ->
                System.out.println(
                        g.getName() + " " + g.getDistance() + ", prev: " + (g.prev != null ? g.prev.getName() : "null")
                )
        );
    }

    private static void dijkstra(List<Vertex> graph, Vertex source) {
        List<Vertex> list = new ArrayList<>(graph);
        // Set source distance to zero
        source.setDistance(0);

        while (!list.isEmpty()) {
            // Choose the vertex which has the smallest distance
            Vertex currentVertex = chooseMinDis(list);
            // Update the current vertex's neighbours distance
            updateNeighboursDistance(currentVertex);
            // Set current visited after updated all the neighbours
            currentVertex.setVisited();
            // Remove the current vertex from the list
            list.remove(currentVertex);
        }
    }

    private static void updateNeighboursDistance(Vertex currentVertex) {
        List<Edge> adjacentEdges = currentVertex.getEdges();
        adjacentEdges.forEach(e -> {
            // Get current edge's linked vertex
            Vertex linkedVertex = e.getLinkedVertex();
            // Update distance only not yet visit
            if (!linkedVertex.isVisited()) {
                int dist = currentVertex.getDistance() +  e.getWeight();
                // Only update distance when shorter
                if (dist < linkedVertex.getDistance()) {
                    linkedVertex.setDistance(dist);
                    linkedVertex.prev = currentVertex;
                }
            }
        });
    }

    private static Vertex chooseMinDis(List<Vertex> graph) {
        Vertex closestVertex = graph.get(0);
        int minDis = closestVertex.getDistance();
        for (Vertex vertex : graph) {
            if (vertex.getDistance() < minDis) {
                minDis = vertex.getDistance();
                closestVertex = vertex;
            }
        }
        return closestVertex;
    }


}
