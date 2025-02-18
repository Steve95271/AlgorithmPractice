package Algorithms.BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBinarySearch {

    int[] arr = {22, 31, 55, 55, 55, 57, 57, 57, 57, 57, 62, 69, 71, 74, 81, 95};

    @Test
    public void testBSLeftMost() {
        System.out.println(BinarySearch03.binarySearchLeftMost(arr, 57));
    }

    @Test
    public void testBS4basicFound() {
        int[] array = {7, 13, 21, 30, 38, 44, 52, 53};
        Assertions.assertEquals(0, BinarySearch4.binarySearchBasic(array, 7));
        Assertions.assertEquals(1, BinarySearch4.binarySearchBasic(array, 13));
        Assertions.assertEquals(2, BinarySearch4.binarySearchBasic(array, 21));
        Assertions.assertEquals(3, BinarySearch4.binarySearchBasic(array, 30));
        Assertions.assertEquals(4, BinarySearch4.binarySearchBasic(array, 38));
        Assertions.assertEquals(5, BinarySearch4.binarySearchBasic(array, 44));
        Assertions.assertEquals(6, BinarySearch4.binarySearchBasic(array, 52));
        Assertions.assertEquals(7, BinarySearch4.binarySearchBasic(array, 53));
    }

    @Test
    public void testBS4basicNotFound() {
        int[] array = {7, 13, 21, 30, 38, 44, 52, 53};
        Assertions.assertEquals(-1, BinarySearch4.binarySearchBasic(array, 15));
        Assertions.assertEquals(-1, BinarySearch4.binarySearchBasic(array, -22));
        Assertions.assertEquals(-1, BinarySearch4.binarySearchBasic(array, 96));
    }

    @Test
    public void testBS4AlternativeFound() {
        int[] array = {7, 13, 21, 30, 38, 44, 52, 53};
        Assertions.assertEquals(0, BinarySearch4.binarySearchBasicAlternative(array, 7));
        Assertions.assertEquals(1, BinarySearch4.binarySearchBasicAlternative(array, 13));
        Assertions.assertEquals(2, BinarySearch4.binarySearchBasicAlternative(array, 21));
        Assertions.assertEquals(3, BinarySearch4.binarySearchBasicAlternative(array, 30));
        Assertions.assertEquals(4, BinarySearch4.binarySearchBasicAlternative(array, 38));
        Assertions.assertEquals(5, BinarySearch4.binarySearchBasicAlternative(array, 44));
        Assertions.assertEquals(6, BinarySearch4.binarySearchBasicAlternative(array, 52));
        Assertions.assertEquals(7, BinarySearch4.binarySearchBasicAlternative(array, 53));
    }

    @Test
    public void testBS4LeftMost() {
        int[] arr = {22, 31, 55, 55, 55, 57, 57, 57, 57, 57, 62, 69, 71, 74, 81, 81, 95};
        Assertions.assertEquals(2, BinarySearch4.binarySearchLeftMost(arr, 55));
        Assertions.assertEquals(5, BinarySearch4.binarySearchLeftMost(arr, 57));
        Assertions.assertEquals(14, BinarySearch4.binarySearchLeftMost(arr, 81));
    }

    @Test
    public void testIntegerMaxValue() {
        int max = Integer.MAX_VALUE;
        System.out.println(max);
        System.out.println();
    }

}
