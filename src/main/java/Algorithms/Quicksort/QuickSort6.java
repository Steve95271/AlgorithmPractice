package Algorithms.Quicksort;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort6 {

    public static void quickSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }

        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);


    }

    private static int partition(int[] arr, int left, int right) {
        //Random rnd = new Random();
        int index = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(arr, left, index);

        int pivot = arr[left];
        int i = left; //find the number smaller then pivot
        int j = right; //find the number smaller then pivot

        while(i < j){
            while(i < j && arr[j] > pivot){
                j--;
            }

            while(i < j && arr[i] <= pivot){
                i++;
            }

            swap(arr, i, j);

        }

        //put pivot to right place
        swap(arr, left, i);

        return i;
    }

    private static void swap (int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
