package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class LeetCode290 {
    public boolean wordPattern(String pattern, String s) {
        String[] patternArr = pattern.split("");
        String[] split = s.split(" ");

        System.out.println(Arrays.toString(patternArr));



        HashSet<Character> patternSet = new HashSet<>();
        HashSet<String> wordSet = new HashSet<>();



        // 'abba' --> [a,b,b,a]
        // s.split('').join()
        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < patternArr.length; i++) {
            if (!hashMap.containsKey(patternArr[i])) {
                hashMap.put(patternArr[i], split[i]);
            } else {
                String word = hashMap.get(patternArr[i]);
                if (!word.equals(split[i])) {
                    return false;
                }
            }
        }

        return true;


    }
}
