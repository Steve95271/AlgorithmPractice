package BinarySearch;

public class BinarySearch1 {
    public static int binarySearch1(int[] arr, int key){
        int minIndex = 0;

        int maxIndex = arr.length - 1;

        while(minIndex <= maxIndex) {

            int midIndex = (minIndex + maxIndex) / 2;

            int midVal = arr[midIndex];

            if (key < midVal){
                maxIndex = midIndex - 1;
            }else if (midVal < key){
                minIndex = midIndex + 1;
            }else {
                return midIndex;
            }
        }

        return -1;
    }

    public static int binarySearchLeftMost(int[] arr, int key) {
        int minIndex = 0;

        int maxIndex = arr.length - 1;

        int candidate = -1;

        while(minIndex <= maxIndex) {

            int midIndex = (minIndex + maxIndex) / 2;

            int midVal = arr[midIndex];

            if (key < midVal){
                maxIndex = midIndex - 1;
            }else if (midVal < key){
                minIndex = midIndex + 1;
            }else {
                candidate = midIndex;

                maxIndex = midIndex - 1;
            }
        }

        return candidate;
    }

    public static int binarySearchRightMost(int[] arr, int key){
        int minIndex = 0;

        int maxIndex = arr.length - 1;

        int candidate = -1;

        while(minIndex <= maxIndex) {

            int midIndex = (minIndex + maxIndex) / 2;

            int midVal = arr[midIndex];

            if (key < midVal){
                maxIndex = midIndex - 1;
            }else if (midVal < key){
                minIndex = midIndex + 1;
            }else {
                candidate = midIndex;

                minIndex = midIndex + 1;
            }
        }

        return candidate;
    }
}
