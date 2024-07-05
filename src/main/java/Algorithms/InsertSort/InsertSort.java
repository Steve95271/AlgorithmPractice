package Algorithms.InsertSort;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序：
 * 把数组分为已排序区域和未排序区域。
 * 左边，[0 ... low - 1] 已排序区域
 * 右边，[low ... array.length - 1] 未排序区域
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int low = 1; low < arr.length; low++) {
            int key = arr[low];
            int leftOfLow = low - 1;

            while (leftOfLow >= 0 && arr[leftOfLow] > key) {
                // 循环内先把插入的位置空出来
                arr[leftOfLow + 1] = arr[leftOfLow];
                leftOfLow--;
            }

            // 循环结束后再把key插入到对应的位置
            // 减少循环内的赋值运算
            if (leftOfLow != low - 1) {
                arr[leftOfLow + 1] = key;
            }
        }
    }
}
