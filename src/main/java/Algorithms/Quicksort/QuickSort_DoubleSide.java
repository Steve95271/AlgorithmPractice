package Algorithms.Quicksort;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort_DoubleSide {

    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(array, left, right);
        sort(array, left, pivotIndex - 1);
        sort(array, pivotIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        // 随机选取一个元素作为基准点，可以降低发生最差情况的可能性
        /*
         获得当前区间的元素个数：right - left + 1
         加上左边界，就能够生成left - right之间的随机索引
         */
        int index = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        // 这样替换原本最左边的元素就不用改动下面的代码
        swap(array, index, left);

        int pivot = array[left]; // 基准点元素。注意：一定要选左边的基准点元素
        int i = left; // i从左向右找比基准点大的
        int j = right; // j从右向左找比基准点小的

        while (i < j) {
            // 注意：一定要从右边的指针 j 开始，不然会乱序
            // 内层的两个while循环的条件一定要加上 i < j
            // 不然两个指针可能会越过对方，造成排序失败

            // j 找比基准点小的
            while (i < j && array[j] > pivot) {
                j--;
            }
            // i 找比基准点大的
            while (i < j && array[i] <= pivot) {
                i++;
            }
            // 交换数组的元素
            swap(array, i, j);
        }

        // 循环结束，把基准点元素交换到合适的位置
        // 这里与 i 或者 j 交换都可以，因为此时它们指向的都是同一个指针
        swap(array, i, left);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
