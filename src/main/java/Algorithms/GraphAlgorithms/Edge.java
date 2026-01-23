package Algorithms.GraphAlgorithms;

public class Edge {

    private Vertex linked;
    private int weight;

    public Edge(Vertex linked) {
        this.linked = linked;
    }

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }

    public Vertex getLinkedVertex() {
        return linked;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "linked=" + linked +
                ", weight=" + weight +
                '}';
    }
}
