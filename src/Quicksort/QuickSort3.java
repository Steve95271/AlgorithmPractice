package Quicksort;

import java.util.Random;

/**
 * This version has improved the pivot selection
 */
public class QuickSort3 {

    public static void main(String[] args) {
/*        Random rnd = new Random();

        int[] arr = new int[1000000];

        for (int i = 0; i < arr.length; i++) {
            int randomNum = rnd.nextInt(1000000);
            arr[i] = randomNum;
        }

        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length-1);
        long end = System.currentTimeMillis();

        System.out.println(end - start);*/


        int[] arr2 = {4,3,7,2,8,5,9,1};

        quickSort(arr2, 0, arr2.length-1);


    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivotIndex = medianOfThree(arr, low, mid, high);
        swap(arr, pivotIndex, high); // Move the pivot to the end

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static int medianOfThree(int[] arr, int low, int mid, int high) {
        if (arr[low] < arr[mid]) {
            if (arr[mid] < arr[high]) {
                return mid;
            } else if (arr[low] < arr[high]) {
                return high;
            } else {
                return low;
            }
        } else {
            if (arr[low] < arr[high]) {
                return low;
            } else if (arr[mid] < arr[high]) {
                return high;
            } else {
                return mid;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
