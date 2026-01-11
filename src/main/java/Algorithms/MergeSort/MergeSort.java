package Algorithms.MergeSort;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] a1) {
        int[] a2 = new int[a1.length];
        split(a1, 0, a1.length - 1, a2);
    }

    public int[] mergeTwo(int[] array) {
        int[] resultArr = new int[array.length];
        int mid = (array.length - 1) >>> 1;
        // merge1(array, 0, mid, mid + 1, array.length - 1, resultArr, 0);
        merge2(array, 0, mid, mid + 1, array.length - 1, resultArr);
        return resultArr;
    }

    private void split(int[] a1, int left, int right, int[] a2) {
//        int[] tempArr = Arrays.copyOfRange(a1, left, right + 1);
//        System.out.println(Arrays.toString(tempArr));
        // 治
        if (left == right) {
            return;
        }
        // 分
        int mid = (left + right) >>> 1;
        split(a1, left, mid, a2);
        split(a1, mid + 1, right, a2);
        // 合
        merge2(a1, left, mid, mid + 1, right, a2);
        System.arraycopy(a2, left, a1, left, right - left + 1);
    }

    /**
     * 合并方法 - 递归实现
     * @param srcArr 原始数组
     * @param left 左半部分的起始索引
     * @param leftEnd 左半部分的结束索引
     * @param right 右半部分的起始索引
     * @param rightEnd 右半部分的结束索引
     * @param tempArr 结果数组
     * @param k 指向要添加的位置
     */
    private void merge1(int[] srcArr, int left, int leftEnd, int right, int rightEnd, int[] tempArr, int k) {
        // 原始数组的左或右其中一边已经为空，把剩余的元素复制到结果数组
        if (left > leftEnd) {
            System.arraycopy(srcArr, right, tempArr, k, rightEnd - right + 1);
            return;
        }
        if (right > rightEnd) {
            System.arraycopy(srcArr, left, tempArr, k, leftEnd - left + 1);
            return;
        }

        // 数组的左半部分和右半部分还没有空，继续递归对比
        if(srcArr[left] < srcArr[right]) {
            tempArr[k] = srcArr[left];
            merge1(srcArr, left + 1, leftEnd, right, rightEnd, tempArr, k + 1);
        } else {
            tempArr[k] = srcArr[right];
            merge1(srcArr, left, leftEnd, right + 1, rightEnd, tempArr, k + 1);
        }
    }

    /**
     * 合并方法 - 非递归实现
     * @param a1 原始数组
     * @param i 左半部分的起始索引
     * @param iEnd 左半部分的结束索引
     * @param j 右半部分的起始索引
     * @param jEnd 右半部分的结束索引
     * @param a2 结果数组
     */
    private void merge2(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2) {
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            // System.out.println(Arrays.toString(a2));
            if (a1[i] < a1[j]) {
                a2[k] = a1[i];
                k++;
                i++;
            } else {
                a2[k] = a1[j];
                k++;
                j++;
            }
        }

//        System.out.println("Left half: " + Arrays.toString(Arrays.copyOfRange(a1, i, iEnd + 1)));
//        System.out.println("Right half: " + Arrays.toString(Arrays.copyOfRange(a1, j, jEnd + 1)));

        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        }
        if (j > jEnd){
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        }

        // System.out.println("merge: " + Arrays.toString(a2));
    }
}
