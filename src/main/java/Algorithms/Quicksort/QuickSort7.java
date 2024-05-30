package Algorithms.Quicksort;

import java.util.Random;

/*
    这个版本是满老师讲解的
 */
public class QuickSort7 {

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left; // 找比基准点大
        int j = left; // 找比基准点小
        int pivot = array[right];

        while (j < right) {
            if (array[j] < pivot) { // j 找到了比基准点小的
                if (i != j) {
                    swap(array, i, j);
                }
                // 当j找到了比基准点小的才移动指针
                // 否则留在原地
                // 因为此时i指向的元素会比基准点大，不应该与j指向的元素交换位置
                i++;
            }
            j++;
        }

        swap(array, i, right);

        return i;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        Random rnd = new Random();

        int[] arr = new int[10000000];

        for (int i = 0; i < arr.length; i++) {
            int randomNum = rnd.nextInt(10000000);
            arr[i] = randomNum;
        }

        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length-1);
        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

}
