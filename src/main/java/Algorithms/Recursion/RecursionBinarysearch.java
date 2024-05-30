package Algorithms.Recursion;

public class RecursionBinarysearch {
    public static void main(String[] args) {
        int[] arr = {12,19,21,42,56,59,136,241,539,9527,10086,43961, 43962};
        System.out.println(binarySearch(arr, 540));
    }

    public static int binarySearch(int[] array, int target) {
        return recursion(array, target, 0, array.length - 1);
    }

    private static int recursion(int[] array, int target, int left, int right) {
        if (left > right) return -1;

        int middle = (left + right) / 2;
        if (target < array[middle]) {
            right = middle - 1;
            return recursion(array, target, left, right);
        } else if (array[middle] < target) {
            left = middle + 1;
            return recursion(array, target, left, right);
        } else{
            return middle;
        }
    }
}
