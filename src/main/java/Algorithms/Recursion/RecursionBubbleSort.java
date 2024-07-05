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
     * 冒泡排序递归算法 - 改进版
     * 在这个版本中，如果传进来的数组已经排序好了，那么时间复杂度是O(n)。
     * 而不是下面bubbleSort2版本的O(n ^ 2)。
     * @param array 整数数组
     * @param bound 未排序的边界
     */
    public static void bubbleSort(int[] array, int bound){
        if (bound == 0){
            return;
        }

        //if array is sorted, mark will not update
        int mark = 0;

        /*
            循环内对array[i]和array[i + 1]的元素进行比较。
            把较大的元素交换到右边去。
         */
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

    /**
     * 这个版本的冒泡排序是每经过一轮排序后，未排序区域的左边界索引减一。
     * 数组中有排序好的部分，也会进行比较。
     * 这个问题在上面的版本得到解决。
     * @param array 需要排序的数组
     * @param unSortIndex 未排序区域的左边界索引
     */
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
