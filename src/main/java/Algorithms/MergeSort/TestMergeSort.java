package Algorithms.MergeSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class TestMergeSort {

    @Test
    void test1() {
        int[] num1 = {1, 5, 6, 9, 2, 4, 7, 8};
        int[] num2 = {3, 7, 1, 4, 9, 2, 5, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeTwo(num1);
        System.out.println("=============================");
        mergeSort.mergeTwo(num2);
    }

    @Test
    void testMergeSort() {
        int numArrays = 12;
        int arrayLength = 1_000_000_0;
        int[][] testArrays = new int[numArrays][arrayLength];

        Random random = new Random();

        // Generate 20 arrays filled with random integers
        for (int i = 0; i < numArrays; i++) {
            for (int j = 0; j < arrayLength; j++) {
                testArrays[i][j] = random.nextInt();
            }
        }

        MergeSort mergeSort = new MergeSort();

        long start = System.currentTimeMillis();
        CompletableFuture<?>[] futures = new CompletableFuture[numArrays];

        for (int i = 0; i < numArrays; i++) {
            final int index = i;
            futures[i] = CompletableFuture.runAsync(() -> {
                mergeSort.sort(testArrays[index]);
            });
        }

        // Wait for all to complete
        CompletableFuture.allOf(futures).join();
        long end = System.currentTimeMillis();

        System.out.println("Execution time: " + (end - start) + "ms");
    }
}
