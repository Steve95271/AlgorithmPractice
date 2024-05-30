package Exercise;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {

        int first = leftMost(nums, target);
        int last = rightMost(nums, target);

        int[] result = {first, last};

        return result;
    }

    private int leftMost(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        int candidate = -1;
        while (left <= right) {
            middle = (left + right) >>> 1;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                candidate = middle;
                right = middle - 1;
            }
        }

        return candidate;
    }

    private int rightMost(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        int candidate = -1;
        while (left <= right) {
            middle = (left + right) >>> 1;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                candidate = middle;
                left = middle + 1;
            }
        }

        return candidate;
    }
}
