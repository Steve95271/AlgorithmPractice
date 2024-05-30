package Exercise;

public class LeetCode136_SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int num = nums[0];

        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
            System.out.println(num);
        }
    }

}
