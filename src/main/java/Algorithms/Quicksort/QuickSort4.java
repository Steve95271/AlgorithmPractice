package Algorithms.Quicksort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort4 {
    public static void quickSort(int arr[], int low, int high) {

        if (low < high) {

            /* pi is partitioning index, arr[pi] is now at right place */

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Before pi

            quickSort(arr, pi + 1, high); // After pi

            //System.out.println(Arrays.toString(arr));

        }

    }
    public static int [] swap(int [] arr, int i, int j){
        int b = arr[i];
        arr[i] = arr[j];
        arr[j] = b;
        return  arr;


    }
    public static int partition (int arr[], int low, int high) {
        // pivot (Element to be placed at right position)
        int pivot = arr[high];

        // Index of smaller element and indicates the
        // right position of pivot found so far
        int i = low-1;

        for (int j = low; j <= high- 1; j++){
            // If current element is smaller than the pivot
            if (arr[j] < pivot){
                i++;    // increment index of smaller element
                swap (arr, i, j);
            }
        }

        swap(arr, i+1, high);
        return (i + 1);
    }

    public static void main(String[] args) {
        /*Random rnd = new Random();

        int[] arr = new int[1000000];

        for (int i = 0; i < arr.length; i++) {
            int randomNum = rnd.nextInt(1000000);
            arr[i] = randomNum;
        }

        long star = System.currentTimeMillis();
        quickSort(arr, 0, arr.length-1);
        long end = System.currentTimeMillis();

        System.out.println(end - star);*/

        int[] nums = {1, 5, 2, 7, 8, 3, 4};
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }
}
