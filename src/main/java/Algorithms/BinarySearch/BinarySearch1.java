package Algorithms.BinarySearch;

public class BinarySearch1 {
    public static int binarySearch1(int[] arr, int key) {
        int leftIndex = 0;

        int rightIndex = arr.length - 1;

        while (leftIndex <= rightIndex) {

            int midIndex = (leftIndex + rightIndex) / 2;

            int midVal = arr[midIndex];

            if (key < midVal) {
                rightIndex = midIndex - 1;
            } else if (midVal < key) {
                leftIndex = midIndex + 1;
            } else {
                return midIndex;
            }
        }

        return -1;
    }

    public static int binarySearchLeftMost(int[] arr, int key) {
        int low = 0;
        int hi = arr.length - 1;
        int candidate = -1;

        while (low <= hi) {
            // Unsigned right operation. Equivalent to divided by 2 but never get negative result.
            int mid = (low + hi) >>> 1;
            int midVal = arr[mid];

            if (key < midVal) {
                hi = mid - 1;
            } else if (midVal < key) {
                low = mid + 1;
            } else {
                candidate = mid;
                hi = mid - 1;
            }
        }

        return candidate;
    }

    public static int binarySearchRightMost(int[] arr, int key) {
        int low = 0;
        int hi = arr.length - 1;
        int candidate = -1;

        while (low <= hi) {
            // Unsigned right operation. Equivalent to divided by 2 but never get negative result.
            int mid = (low + hi) >>> 1;
            System.out.println("mid: " + mid);
            int midVal = arr[mid];
            if (key < midVal) {
                hi = mid - 1;
            } else if (midVal < key) {
                low = mid + 1;
            } else {
                candidate = mid;
                low = mid + 1;
            }
        }

        return candidate;
    }
}
