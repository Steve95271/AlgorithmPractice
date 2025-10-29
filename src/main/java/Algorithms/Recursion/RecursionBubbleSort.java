package Algorithms.Recursion;

import java.util.Arrays;

public class RecursionBubbleSort {

    public static void sort(int[] array) {
        sort(array, array.length - 1);
    }

    private static void sort(int[] array, int unSortBoundary) {

        if (unSortBoundary == 0) {
            return;
        }

        for (int i = 0; i < unSortBoundary; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }

        sort(array, unSortBoundary - 1);
    }

}
