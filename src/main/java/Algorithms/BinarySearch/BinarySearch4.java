package Algorithms.BinarySearch;

public class BinarySearch4 {

    public static int binarySearchBasic(int[] array, int target) {
        int left = 0; // left pointer
        int right = array.length - 1; // right pointer

        while (left <= right) {
            // Unsigned right shift operation.
            // Fix the problem that if (left + right) > Integer.MAX_VALUE will encounter negative number.
            int middle = (left + right) >>> 1;
            if (target < array[middle]) {
                right = middle - 1;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                // return the target index
                return middle;
            }
        }

        return -1;
    }

    public static int binarySearchBasicAlternative(int[] array, int target) {
        int left = 0;
        /*
        right pointer is diff from above version.
        The right pointer point to the element isn't involved in finding the target.
         */
        int right = array.length;

        // While loop exit condition has been changed to left smaller than right only.
        // Because element of right pointer isn't involved in finding the target.
        // If not change, when looking for an inexistence element will encounter infinite loop
        while (left < right) {
            int middle = (left + right) >>> 1; // right shift 1 bit.
            if (target < array[middle]) {
                right = middle; // is not middle - 1 anymore.
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static int binarySearchLeftMost(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int candidate = -1;

        while (left <= right) {
            int middle = (left + right) >>> 1;
            int midVal = array[middle];
            if (target < midVal) {
                right = middle - 1;
            } else if (midVal < target) {
                left = middle + 1;
            } else {
                candidate = middle;
                right = middle - 1;
            }
        }

        return candidate;
    }

}
