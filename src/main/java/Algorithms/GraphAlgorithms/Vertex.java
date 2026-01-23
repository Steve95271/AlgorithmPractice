package Algorithms.GraphAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
