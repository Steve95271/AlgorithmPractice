package Algorithms.Quicksort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class TestQuickSort {
    private final int[] array = {19, 4,1,6,5,3,7,8,2,16, 23, 31, 15, 22};
    private static int[] largeArray = new int[10000000];
    private static Random rnd = new Random(System.currentTimeMillis());

    private static void initArr() {
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = rnd.nextInt(10000000);
        }
    }

    @Test
    void testQuickSort_SingleSide() {
        initArr();
        long start = System.currentTimeMillis();
        QuickSort_SingleSide.sort(largeArray, 0, largeArray.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + " ms");
        for (int i = 0; i < 10; i++) {
            System.out.print(largeArray[i] + " ");
        }
    }

    @Test
    void testQuickSort_DoubleSide() {
        initArr();
        long start = System.currentTimeMillis();
        QuickSort_DoubleSide.sort(largeArray, 0, largeArray.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + " ms");
        for (int i = 0; i < 10; i++) {
            System.out.print(largeArray[i] + " ");
        }
    }
}
