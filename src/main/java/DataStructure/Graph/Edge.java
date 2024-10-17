package DataStructure.Graph;

public class Edge {

    Vertex linked;
    int weight;

    public Edge(Vertex linked) {
        this.linked = linked;
    }

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }

}
