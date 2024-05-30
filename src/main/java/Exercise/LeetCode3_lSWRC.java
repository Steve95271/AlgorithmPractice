package Exercise;

import java.util.HashMap;

public class LeetCode3_lSWRC {

    /*

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

     */

    /*
    要点：
        1.用begin和end表示子字符串的开始和结束位置
        2.用hashmap检查重复字符串
        3.从左想有查看每个自负，如果：
         - 没遇到重复字符，调整end
         - 遇到重复的字符，调整begin
         - 将当前字符放入hashmap
        4.end - begin + 1 是当前子字符串的长度
    */

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int begin = 0;
        int end;
        int max = 0;
        for (end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (hashMap.containsKey(c)) {
                begin = Math.max(begin, hashMap.get(c) + 1);
            }
            hashMap.put(c,end);
            System.out.println(s.substring(begin, end + 1));
            max = Math.max(max, end - begin + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

        System.out.println("===============");

        System.out.println(lengthOfLongestSubstring("bbbbb"));

        System.out.println("================");

        System.out.println(lengthOfLongestSubstring("abba"));

    }

}
