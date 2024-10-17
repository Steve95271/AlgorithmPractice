package DataStructure.Graph;

import java.util.List;

public class Vertex {

    public String name;
    public List<Edge> edges;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
