package Algorithms.InsertSort;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {
    public static void main(String[] args) {
        Random rnd = new Random();

        int[] arr = new int[7];

        for (int i = 0; i < arr.length; i++) {
            int randomNum = rnd.nextInt(100);

            arr[i] = randomNum;
        }

        System.out.println(Arrays.toString(arr));

        insertSort(arr);

        System.out.println(Arrays.toString(arr));


    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int index = i-1;

            while(index >= 0 && arr[index] > key){
                //Swap the number
                arr[index + 1] = arr[index];
                index = index - 1;
                arr[index + 1] = key;
            }
        }
    }

}
