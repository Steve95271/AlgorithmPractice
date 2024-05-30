package Exercise;

import java.util.*;

public class LeetCode49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> stringList = hashMap.get(key);
            if (stringList == null) {
                stringList = new ArrayList<>();
                hashMap.put(key, stringList);
            }
            stringList.add(str);
        }

        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        LeetCode49_GroupAnagrams leetCode49GroupAnagrams = new LeetCode49_GroupAnagrams();

        leetCode49GroupAnagrams.groupAnagrams(strs);
    }

}
