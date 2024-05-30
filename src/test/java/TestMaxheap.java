import DataStructure.Heap.MaxHeap;
import org.junit.jupiter.api.Test;

public class TestMaxheap {

    @Test
    void test1() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(array);
        maxHeap.print();
    }

}
