package Algorithms.Recursion;

import java.util.Arrays;

public class RecursionBubbleSort {
    public static void main(String[] args) {

        int[] arr1 = {5,2,6,1,8,3,4,9};
        int[] arr2 = {4,9,6,1,8,3,5,2};
        int[] arr3 = {9,6,5,4,3,2,1};

        bubbleSort2(arr1, arr1.length-1);
        bubbleSort2(arr2, arr2.length-1);
        bubbleSort2(arr3, arr3.length-1);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

    }

    /**
     * 冒泡排序递归算法
     * @param array 整数数组
     * @param bound 是未排序的边界
     */
    public static void bubbleSort(int[] array, int bound){
        if (bound == 0){
            return;
        }

        //if array is sorted, mark will not update
        int mark = 0;

        for (int i = 0; i < bound; i++) {
            if (array[i] > array[i+1]){
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                mark = i;
            }
        }

        bubbleSort(array, mark);
    }

    public static void bubbleSort2(int[] array, int unSortIndex) {
        if (unSortIndex == 0) {
            return;
        }

        for (int i = 0;  i < unSortIndex; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }

        unSortIndex = unSortIndex - 1;

        bubbleSort(array, unSortIndex);
    }
}
