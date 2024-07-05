package Algorithms.BinarySearch;

import org.junit.jupiter.api.Test;

public class TestBinarySearch {

    int[] arr = {22, 31, 55, 55, 55, 57, 57, 57, 57, 57, 62, 69, 71, 74, 81, 95};

    @Test
    public void testBSLeftMost() {
        System.out.println(BinarySearch03.binarySearchLeftMost(arr, 57));
    }

}
