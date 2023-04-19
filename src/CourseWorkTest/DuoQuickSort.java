package CourseWorkTest;

import java.util.Arrays;

public class DuoQuickSort {
    public static void main(String[] args) {
        int[] arr ={4,9,5,1,6,2,8,3,7};

        dualPivotQuickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }


    public static void dualPivotQuickSort(int[] array, int left, int right) {
        if (right > left) {
            if (array[left] > array[right]) {
                swap(array, left, right);
            }

            int pivot1 = array[left];
            int pivot2 = array[right];

            int i = left + 1;
            int lt = left + 1;
            int gt = right - 1;

            while (i <= gt) {
                if (array[i] < pivot1) {
                    swap(array, i, lt);
                    i++;
                    lt++;
                } else if (array[i] > pivot2) {
                    swap(array, i, gt);
                    gt--;
                } else {
                    i++;
                }
            }

            swap(array, left, lt - 1);
            swap(array, right, gt + 1);

            dualPivotQuickSort(array, left, lt - 2);
            dualPivotQuickSort(array, lt, gt);
            dualPivotQuickSort(array, gt + 2, right);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
