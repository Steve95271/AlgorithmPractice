package TestClasses;

import java.util.Arrays;

public class HeapSortPractice {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 7, 6, 4, 5};
        System.out.println("Unsorted array: " + Arrays.toString(a));
        new HeapSortPractice().sort(a);
        System.out.println("Sorted array: " + Arrays.toString(a));
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * 下潜方法：
     *   - 把父节点与它的两个左右子节点做比较，较大的子节点交换上去成为父节点
     *   - 计算左右子节点的公式：
     *       - left = parent * 2 + 1
     *       - right = parent * 2 + 2
     * */
    private void down(int[] arr, int parent, int size) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;

        if (left < size && arr[left] > arr[max]) {
            max = left;
        }

        if (right < size && arr[right] > arr[max]) {
            max = right;
        }

        // 当有子节点有比父节点大的才进行交换
        if (max != parent) {
            swap(arr, max, parent);
            down(arr, max, size);
        }
    }

    /*
     * 建堆算法：
     *  - 找到最后一个非叶子节点(size / 2 - 1)
     *  - 从后向前，对每个节点执行下潜
     * */
    private void heapify(int[] arr) {
        int lastNonLeafNote = arr.length / 2 - 1;

        for (int i = lastNonLeafNote; i >= 0; i--) {
            down(arr, i, arr.length);
        }
    }

    /*
     * 大顶堆排序思路：
     *   - 把大顶堆的堆顶元素交换到最后
     *   - 再通过下潜方法恢复大顶堆的结构
     *   - 每次交换后，右边界减一
     *   - 重复上面步骤，知道右边界指针为零
     * */
    private void sort(int[] arr) {
        heapify(arr);
        System.out.println("Heapifed: " + Arrays.toString(arr));
        for (int right = arr.length - 1; right > 0; right--) {
            swap(arr, 0, right);
            down(arr, 0, right);
        }
    }
}
