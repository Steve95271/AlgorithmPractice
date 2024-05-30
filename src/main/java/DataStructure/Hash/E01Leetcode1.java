package DataStructure.Hash;

import java.util.HashMap;

/**
 * 两数之和
 * 给定一个整数数组numbers，和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，
 * 并返回他们的数组下标
 *
 * 注意：只会存在一个有效答案
 */
public class E01Leetcode1 {
    /*
    思路：
    1. 循环遍历数组，拿到每个数字x
    2. 以target - x 作为key到hash表查找
        1）没找到，将x作为key，它的索引作为value放入hash表
        2）找到了，返回x和它配对数的索引即可
     */

    public int[] twoSum(int[] numbers, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            int y = target - x;
            if (map.containsKey(y)){
                return new int[] {i, map.get(y)};
            }else {
                map.put(x,i);
            }
        }
        return null;
    }
}
