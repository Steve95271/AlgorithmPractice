package Algorithms.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
/*        Random rnd = new Random();

        int[] arr = new int[200000];

        for (int i = 0; i < arr.length; i++) {
            int randomNum = rnd.nextInt(100000);

            arr[i] = randomNum;
        }*/

        int[] arr2 = {4,2,6,7,1,3,5};

        //recursiveBubbleSort(arr, arr.length - 1);

        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    private static void recursiveBubbleSort(int[] array, int arrayLength) {
        if (arrayLength == 0) {
            return;
        }

        int x = 0; //record the sorted position

        for (int i = 0; i < arrayLength ; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                x = i;
            }
        }

        recursiveBubbleSort(array, x);
    }

    private static void bubbleSort(int[] array){
        int x = 0;
        int j = array.length-1;

        do {
            for (int i = 0; i < j ; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    x = i;
                }
            }
            j = x;

        }while(j != 0);
    }


}
