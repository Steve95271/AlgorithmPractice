package Graph;

import java.util.LinkedList;

public class Bfs {

    public void bfs(Vertex vertex){
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.offer(vertex);
        vertex.visited = true;

        while(!queue.isEmpty()){
            Vertex headVertexInQueue = queue.poll();
            System.out.println(headVertexInQueue.name);

            for (Edge edge:headVertexInQueue.edges) {
                if (!edge.linkedVertex.visited){
                    edge.linkedVertex.visited = true;
                    queue.offer(edge.linkedVertex);
                }
            }
        }
    }
}
