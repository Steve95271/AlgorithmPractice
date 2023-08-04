package Graph;

import java.util.List;

public class Vertex {
    static final Integer INFINITE = Integer.MAX_VALUE;
    String name;
    List<Edge> edges;

    //记录上一个节点
    Vertex prev = null;

    int distance = INFINITE;



    //Whether be visited. False means not yet be visited.
    Boolean visited = false;

    public Vertex (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
