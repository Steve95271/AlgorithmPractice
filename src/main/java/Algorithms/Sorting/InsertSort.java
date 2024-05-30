package Algorithms.Sorting;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {4,2,6,7,1,3,5};

        insertSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int key = array[i];

            //insert key into the sorted sequence
            int j = i - 1;

            while(j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }
    }
}
