package Algorithms.BubbleSort;

import java.util.Arrays;

public class BubbleSort {

    private static void sort(int[] nums) {
        int j = nums.length - 1;

        do {
            int x = 0;
            for (int i = 0; i < j; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    x = i;
                }
                System.out.println(x);
                System.out.println(Arrays.toString(nums));
            }
            j = x;
        } while (j != 0);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,4,5};
        sort(nums);
    }

}
