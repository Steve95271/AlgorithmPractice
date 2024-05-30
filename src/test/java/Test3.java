import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test3 {

    /***
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     *
     * Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * Example 2:
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     *
     * Example 3:
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     * Constraints:
     * Only one valid answer exists.
     *
     */
    public static List<Integer> twoSum(List<Integer> nums, Integer target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List result = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            int numLookingFor = target - nums.get(i);

            if (hashMap.containsKey(numLookingFor)){
                result.add(hashMap.get(numLookingFor));
                result.add(i);
                return result;
            } else {
                hashMap.put(nums.get(i), i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 2,7,11,15);
        System.out.println(twoSum(nums, 9));

        System.out.println("------------");

        nums.clear();
        Collections.addAll(nums, 3,2,4);
        System.out.println(twoSum(nums, 6));

        System.out.println("--------------");

        nums.clear();
        Collections.addAll(nums, 3,3);
        System.out.println(twoSum(nums, 6));
    }

}
