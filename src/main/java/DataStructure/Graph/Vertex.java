package DataStructure.Graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private final String name;
    private List<Edge> edges = new ArrayList<>();
    private boolean visited = false;
    private int distance = Integer.MAX_VALUE; // Default distance, represent infinite
    public Vertex prev = null;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addEdge(List<Edge> edges) {
        this.edges.addAll(edges);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "{" +
                "vertex='" + name + '\'' +
                ", distance=" + distance +
                ", prev =" + (prev != null ? prev.name : "null") +
                '}';
    }
}
