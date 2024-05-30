package DataStructure.Hash;

import java.util.HashMap;

/**
 * 检查字符串
 * 返回不重复的最大长度
 */
public class E02Leetcode3 {
    /*
    要点：
        1.用begin和end表示子串开始和结束位置
        2.用hash表检查重复字符
        3.从左向右查看每个字符，如果：
            -没遇到重复字符，调整end
            -遇到重复的字符，调整begin
            -将当前字符放入hash表
        4.end - begin + 1 是当前子串长度
     */

    public static int lengthOfLongestSubstring(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {//重复
                begin = Math.max(begin, map.get(ch) + 1);
                map.put(ch, end);
            } else {
                map.put(ch, end);
            }
            System.out.println(s.substring(begin, end + 1));
            maxLength = Math.max(maxLength, end - begin + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
