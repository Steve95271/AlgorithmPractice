package InsertSort;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {
    public static void main(String[] args) {
        Random rnd = new Random();

        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            int randomNum = rnd.nextInt(100);

            arr[i] = randomNum;
        }

        System.out.println(Arrays.toString(arr));

        int[] sortedArr = insertSort(arr);

        System.out.println(Arrays.toString(sortedArr));


    }

    public static int[] insertSort(int[] arr){

        int startIndex = getStartIndex(arr);

        for (int i = startIndex; i < arr.length; i++) {
            //Mark the index that is needed to insert
            int j = i;

            //Sorting it from startIndex to front
            while (j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        return arr;


    }

    public static int getStartIndex(int[] arr){
        int startIndex = -1;

        //Find the index that start sorting from which one
        for (int i = 0; i < arr.length; i++) {
            // if find the element greater than the next one then stop
            if (arr[i] > arr[i+1]){
                //This is the index of the unordered number of array
                return startIndex = i + 1;
            }
        }

        return startIndex;
    }
}
