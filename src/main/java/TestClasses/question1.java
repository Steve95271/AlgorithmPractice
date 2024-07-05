package TestClasses;

import java.util.Arrays;
import java.util.Collections;

public class question1 {

    public int maximumGap(int[] nums) {
        //在此处完成相关代码
        if (nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int max = 0;

        for (int i = nums.length - 1; i > 0 ; i--) {
            int a = nums[i] - nums[i - 1];

            if (a > max) {
                max = a;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,9,1};
        System.out.println(new question1().maximumGap(arr));
    }

}
