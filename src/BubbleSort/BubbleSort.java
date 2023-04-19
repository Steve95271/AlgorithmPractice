package BubbleSort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        Random rnd = new Random();

        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            int randomNum = rnd.nextInt(100);

            arr[i] = randomNum;
        }

        //Print the random array
        System.out.println(Arrays.toString(arr));

        //Outer loop is for how many times is going to iterate
        //How many times depend on element - 1
        //Why - 1? Because it needs to compare the element[i] and element[i+1]
        //So is for prevent index out of bound.
        for (int i = 0; i < arr.length-1; i++) {
            //Inner loop  is for compare the larger element and place it to the right
            //- 1: preventing out of bound.
            //- j: We don't need it to compare the element is sorted to the right.
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j+1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        //Print the sorted array
        System.out.println(Arrays.toString(arr));
    }


}
