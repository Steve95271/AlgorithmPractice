import Algorithms.Recursion.Fibonacci;
import Algorithms.Recursion.FibonacciMemoization;
import Algorithms.Recursion.RecursionBinarySearch;
import Algorithms.Recursion.ReverseStringPrinting;
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

    @Test
    void testFibo(){
        int result = Fibonacci.calculate(10);
        Assertions.assertEquals(55, result);
    }

    @Test
    void testReverseStringPrinting() {
        ReverseStringPrinting.print("hello");
    }

    @Test
    void testRecursionBinarySearch() {
        int[] array = {1, 5, 6, 23, 41, 56, 78, 121, 243, 261};

        Assertions.assertEquals(1, RecursionBinarySearch.search(array, 5));
        Assertions.assertEquals(2, RecursionBinarySearch.search(array, 6));
        Assertions.assertEquals(3, RecursionBinarySearch.search(array, 23));
        Assertions.assertEquals(4, RecursionBinarySearch.search(array, 41));
        Assertions.assertEquals(7, RecursionBinarySearch.search(array, 121));
        Assertions.assertEquals(-1, RecursionBinarySearch.search(array, 3));
    }

}
