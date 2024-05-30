package Algorithms.SelectionSort;

import java.util.Arrays;

public class SelectionSort {

    static void sort(int[] nums) {
        // print before sort
        System.out.println(Arrays.toString(nums));
        System.out.println("===================");

        for (int right = nums.length - 1; right > 0; right--) {
            // Assume the max value at the right
            // variable max is an index
            int max = right;
            for (int i = 0; i < right; i++) {
                if (nums[i] > nums[max]) {
                    max = i;
                }
            }
            if (max != right) {
                int temp = nums[max];
                nums[max] = nums[right];
                nums[right] = temp;
            }
            // print array
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,4,6,5};
        sort(nums);
    }

}
