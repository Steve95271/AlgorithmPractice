package Algorithms.MergeSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestMergeSort {

    @Test
    void test1() {
        int[] num1 = {1, 5, 6, 9, 2, 4, 7, 8};
        MergeSort mergeSort = new MergeSort();
        int[] nums = mergeSort.mergeTwo(num1);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void testMergeSort() {
        int[] nums = {3, 7, 1, 4, 9, 2, 5, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));

    }
}
