package BinarySearch;

/**
 * This is an improved version.
 * Fixed the problem that if the target is grater than a middle value would cause more time
 */
public class BinarySearch2 {
    public static int binarySearch(int[] arr, int target){
        int min = 0;

        int max = arr.length;

        while(max - min > 1){
            //Binary right move operation
            //Is for divide the number 2 but would not get the negative number in Java
            int mid = (min + max) >>> 1;

            if (target < arr[mid]){
                max = mid;
            }else {
                min = mid;
            }
        }

        if (arr[min] == target){
            return min;
        }else {
            return -1;
        }
    }
}
