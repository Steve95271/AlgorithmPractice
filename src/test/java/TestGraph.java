import DataStructure.Graph.Edge;
import DataStructure.Graph.Vertex;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestGraph {

    @Test
    void test1() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.edges = List.of(new Edge(b), new Edge(c));
        b.edges = List.of(new Edge(d));
        c.edges = List.of(new Edge(d));
        d.edges = List.of();
    }

}
