package Quicksort;

import java.util.*;

public class QuickSort1 {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomNum = rnd.nextInt(1000000);
            arr[i] = randomNum;
        }

        int[] arr2 = {4,1,7,2,8,5,9,3};

        quickSort(arr2, 0, arr2.length - 1);

        System.out.println(Arrays.toString(arr2));

    }
}
