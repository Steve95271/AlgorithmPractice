import Algorithms.GraphAlgorithms.Edge;
import Algorithms.GraphAlgorithms.Vertex;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestGraph {

    @Test
    void test1() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.addEdge(List.of(new Edge(b), new Edge(c)));
        b.addEdge(List.of(new Edge(d)));
        c.addEdge(List.of(new Edge(d)));
        d.addEdge(List.of());
    }

}
