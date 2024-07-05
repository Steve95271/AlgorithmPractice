package TestClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class question3 {

    public static String removeDuplicates(int[] nums) {
        //请在此处完成相关代码
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                arr.add(nums[i]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(set.size());
        stringBuilder.append(",nums=" + arr);

        return arr.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};

        System.out.println(removeDuplicates(arr));
    }

}
