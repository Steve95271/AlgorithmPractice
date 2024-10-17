package DataStructure.Graph_Old_ver;

public class Edge {
    Vertex linkedVertex;
    int weight;

    public Edge(Vertex linkedVertex) {
        this(linkedVertex, 1);
    }

    public Edge(Vertex linkedVertex, int weight){
        this.linkedVertex = linkedVertex;
        this.weight = weight;
    }
}
