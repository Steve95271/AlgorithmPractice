package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BellmanFordDP {
    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

     /*
            f(v) 用来表示从起点出发，到达 v 这个顶点的最短距离
            初始时
            f(v) = 0   当 v==起点 时
            f(v) = ∞   当 v!=起点 时

            之后
            新           旧     所有from
            f(to) = min(f(to), f(from) + from.weight)

            from 从哪来
            to   到哪去

            f(v4) = min( ∞, f(v3) + 11 ) = 20
            f(v4) = min( 20, f(v2) + 15 ) = 20


            v1  v2  v3  v4  v5  v6
            0   ∞   ∞   ∞   ∞   ∞
            0   7   9   ∞   ∞   14  第一轮
            0   7   9   20  23  11  第二轮
            0   7   9   20  20  11  第三轮
            0   7   9   20  20  11  第四轮
            0   7   9   20  20  11  第五轮

     */

    public static void main(String[] args) {
        List<Edge> edges = List.of(
                new Edge(6, 5, 9),
                new Edge(4, 5, 6),
                new Edge(1, 6, 14),
                new Edge(3, 6, 2),
                new Edge(3, 4, 11),
                new Edge(2, 4, 15),
                new Edge(1, 3, 9),
                new Edge(1, 2, 7)
        );

        // 一维数组缓存顶点的距离
        // 顶点编号与索引对应，因此索引0不会被用上
        int[] vertexDistances = new int[7];
        vertexDistances[1] = 0; // 顶点V1为起始顶点，设距离为0
        for (int i = 2; i < vertexDistances.length; i++) {
            vertexDistances[i] = Integer.MAX_VALUE; // 剩余的顶点初始距离为无限（用整数最大值来代表）
        }

        boolean isUpdated;
        while (true) {
            isUpdated = false;

            for (Edge edge : edges) {
                if (vertexDistances[edge.from] != Integer.MAX_VALUE) { // from顶点的距离还是无限的时候不应该更新
                    int distance = vertexDistances[edge.from] + edge.weight;
                    if (distance < vertexDistances[edge.to]) {
                        vertexDistances[edge.to] = distance;
                        isUpdated = true;
                    }
                }
            }

            print(vertexDistances);

            if (!isUpdated) { // 如果某一轮没有更新过顶点，说明所有顶点的距离已经找到了最短距离
                break;
            }
        }
    }

    private static void print(int[] dp) {
        System.out.println(Arrays.stream(dp)
                .mapToObj(i -> i == Integer.MAX_VALUE ? "∞" : String.valueOf(i))
                .collect(Collectors.joining(",", "[", "]")));
    }
}
