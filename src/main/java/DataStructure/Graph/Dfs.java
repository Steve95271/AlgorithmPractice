package DataStructure.Graph;

public class Dfs {

    public void dfs(Vertex vertex){
        vertex.visited = true;
        System.out.println(vertex.name);

        for (Edge edge: vertex.edges) {
            if (!edge.linkedVertex.visited){
                dfs(edge.linkedVertex);
            }
        }
    }
}
