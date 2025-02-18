import Algorithms.Recursion.FibonacciMemoization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRecursion {

    @Test
    void testFiboMemo() {
        FibonacciMemoization fm = new FibonacciMemoization();
        Assertions.assertEquals(1, fm.calculateFib(2));
        Assertions.assertEquals(2, fm.calculateFib(3));
        Assertions.assertEquals(3, fm.calculateFib(4));
        Assertions.assertEquals(5, fm.calculateFib(5));
        Assertions.assertEquals(8, fm.calculateFib(6));
        Assertions.assertEquals(13, fm.calculateFib(7));
        Assertions.assertEquals(21, fm.calculateFib(8));
        Assertions.assertEquals(34, fm.calculateFib(9));
    }

    @Test
    void testFiboMemo2() {
        FibonacciMemoization fm = new FibonacciMemoization();
        System.out.println(fm.calculateFib(3000));
    }

}
