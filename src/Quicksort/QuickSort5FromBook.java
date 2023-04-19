package Quicksort;

import java.util.Arrays;

public class QuickSort5FromBook {
    public static void main(String[] args) {
        int[] arr = {8,9,2,6,5,3,7,1,4};

        int[] arr2 = new int[2];

        //arr2 = Partition(arr, 0, arr.length-1);

        QuickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void QuickSort(int[]arr, int low, int hi){
        if (low < hi){
            int[] pivotIndex = Pivot2(arr, low, hi);
            QuickSort(arr, low, pivotIndex[0] - 1);
            QuickSort(arr, pivotIndex[0], pivotIndex[1]);
            QuickSort(arr, pivotIndex[0] + 1, hi);
        }
    }

    public static int[] Pivot2(int[]arr, int low, int hi){
        //pick the last number of array as pivot
        int pivot1 = arr[hi];

        //position of index where pivot should put in
        int index1 = low -1;

        for (int i = low; i < hi; i++) {
            if (arr[i] <= pivot1){
                index1 = index1 + 1;
                int temp = arr[index1];
                //Exchange these two number, greater number go to the right side
                arr[index1] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[index1 + 1];
        arr[index1 + 1] = arr[hi];
        arr[hi] = temp;


        int[] pivotArr = new int[2];
        pivotArr[0] = index1 + 1;

        //Second pivot
        int pivot2 = arr[hi];

        int index2 = pivotArr[0]-1;

        for (int i = pivotArr[0]; i < hi; i++) {
            if (arr[i] <= pivot2){
                index2 = index2 + 1;
                int temp2 = arr[index2];
                //Exchange these two number, greater number go to the right side
                arr[index2] = arr[i];
                arr[i] = temp2;
            }
        }

        int temp3 = arr[index2 + 1];
        arr[index2 + 1] = arr[hi];
        arr[hi] = temp3;

        pivotArr[1] = index2 + 1;

        return pivotArr;
    }
}
