package Algorithms.Quicksort;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = {19, 4,1,6,5,3,7,8,2,16, 23, 31, 15, 22};

        QuickSort6.quickSort(arr1, 0, arr1.length-1);

        System.out.println(Arrays.toString(arr1));

        Random rnd = new Random();

        int[] arr2 = new int[100000000];

        for (int i = 0; i < arr2.length; i++) {
            int randomNum = rnd.nextInt(100000000);
            arr2[i] = randomNum;
        }

        long star = System.currentTimeMillis();
        QuickSort6.quickSort(arr2, 0, arr2.length-1);
        long end = System.currentTimeMillis();

        System.out.println(end - star);
    }
}
