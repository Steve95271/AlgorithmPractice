package Quicksort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {
    public static void main(String[] args) {
        Random rnd = new Random();

        int[] arr = new int[1000000];

        for (int i = 0; i < arr.length; i++) {
            int randomNum = rnd.nextInt(1000000);
            arr[i] = randomNum;
        }

        //int[] arr2 = {4,1,7,2,8,5,9,3};

        //quickSort(arr2, 0, arr2.length-1);

        //System.out.println(Arrays.toString(arr));

        long star = System.currentTimeMillis();
        quickSort(arr, 0, arr.length-1);
        long end = System.currentTimeMillis();

        System.out.println(end - star);

        //System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int low, int hi){
        int left = low;
        int right = hi;

        if (left > right){
            return;
        }

        int pivot = arr[low];


        while(left != right){
            //Find the number less than pivot from the right
            while(true){
                if (right <= left || arr[right] < pivot){
                    break;
                }
                //update index
                right--;
            }

            //Find the number greater than pivot from the left
            while(true){
                if (right <= left || arr[left] > pivot){
                    break;
                }
                //update index
                left++;
            }

            //Swap element
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }


        int temp = arr[low];
        arr[low] = arr[left];
        arr[left] = temp;

        //Sort left side
        quickSort(arr, low, left-1);
        //Sort right side
        quickSort(arr, left+1, hi);
    }
}
