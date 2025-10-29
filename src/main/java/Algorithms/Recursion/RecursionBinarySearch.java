package Algorithms.Recursion;

public class RecursionBinarySearch {

    public static int search(int[] array, int target) {

        return recursionSearch(array, target, 0, array.length - 1);

    }

    private static int recursionSearch(int[] array, int target, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) >>> 1; // unsigned right shift operation
        if (target < array[mid]) {
            return recursionSearch(array, target, left, mid - 1);
        } else if (target > array[mid]) {
            return recursionSearch(array, target, mid + 1, right);
        } else {
            return mid;
        }

    }

}
