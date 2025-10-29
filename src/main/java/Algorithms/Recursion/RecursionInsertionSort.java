package Algorithms.Recursion;

import java.util.Arrays;
import java.util.Random;

public class RecursionInsertionSort {

    public static void main(String[] args) {
        Random rnd = new Random();

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int randomNum = rnd.nextInt(100);

            arr[i] = randomNum;
        }

        System.out.println(Arrays.toString(arr));

        insertSort(arr, 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        insertSort(arr, 1);
    }


    /**
     * 递归版本插入排序
     *
     * @param arr 需要排序的数组
     * @param low 未排序区域的左边界指针
     */
    private static void insertSort(int[] arr, int low) {
        if (low == arr.length) {
            return;
        }

        int i = low - 1; //已排序区域的指针。指针的左边已排序。

        while (i >= 0 && arr[i] > arr[i + 1]) {
            /*
             * while the value at the left greater than the right
             * exchange their position
             * */
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
            i--;
        }

        insertSort(arr, low + 1);
    }

    private static void insertSort2(int[] arr, int low) {
        if (low == arr.length) {
            return;
        }

        int key = arr[low];
        int i = low - 1; //已排序区域的指针。指针的左边已排序。

        while (i >= 0 && arr[i] > arr[i + 1]) {
            /*
            * While the left value is greater,
            * move it to the right.
            * Leave space for insertion
            * */
            arr[i + 1] = arr[i];
            i--;
        }

        /*
        * Check if any value have been moved.
        * If while statement has not moved any value, the i index will equal to low index.
        * Vice versa, there will be a space at i + 1 position to be inserted the "key"
        * */
        if (i + 1 != low) {
            arr[i + 1] = key;
        }

        insertSort2(arr, low + 1);
    }

}
