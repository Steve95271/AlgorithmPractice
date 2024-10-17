package DataStructure.Graph_Old_ver;

import java.util.ArrayList;
import java.util.List;

public class DijkstraWithPriorityQueue {
    public void dijkstra(List<Vertex> graph, Vertex source){
        ArrayList<Vertex> vertexList = new ArrayList<>(graph);

        source.distance = 0;

        while(!vertexList.isEmpty()){
            //选择当前vertex
            Vertex currentVertex = chooseMinDis(vertexList);

            //更新当前vertex邻居的距离
            updateNeighborsDistance(currentVertex);

            //移除当前顶点
            vertexList.remove(currentVertex);

            currentVertex.visited = true; //已被访问过
        }

        for (Vertex v : graph) {
            Vertex prevVertex = v.prev;
            System.out.print(v.name + " ");

            while(prevVertex != null){
                System.out.print("<-- " + prevVertex.name + " ");
                prevVertex = prevVertex.prev;
            }

            System.out.print("Distance: " + v.distance + "\n");


        }
    }

    private void updateNeighborsDistance(Vertex currentVertex) {
        for (Edge edge : currentVertex.edges) {
            //获取连接的邻居顶点
            Vertex neighbor = edge.linkedVertex;
            if (!neighbor.visited){
                int distance = currentVertex.distance + edge.weight;
                if (distance < neighbor.distance){
                    neighbor.distance = distance;
                    neighbor.prev = currentVertex;
                }
            }
        }
    }

    private Vertex chooseMinDis(ArrayList<Vertex> vertexList) {
        //让List中第一个vertex为距离最小
        Vertex min = vertexList.get(0);

        for (int i = 1; i < vertexList.size(); i++) {
            if (vertexList.get(i).distance < min.distance){
                min = vertexList.get(i);
            }
        }

        return min;
    }
}
