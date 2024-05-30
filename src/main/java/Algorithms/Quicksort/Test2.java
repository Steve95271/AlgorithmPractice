package Algorithms.Quicksort;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        int result = solution(3,100000);
        System.out.println(result);


    }

    static Map<String, Integer> memo = new HashMap<>();

    static int solution(int d, int k) {
        if (d == 0 && k > 0 || k < 0 || d < 0)
            return 0;
        else if (d == 0 && k == 0)
            return 1;

        String key = d + "," + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            res += solution(d - 1, i);
        }

        memo.put(key, res);
        return res;
    }



    static int solution1(int d, int k)
    {
        if(d == 0 && k > 0 || k < 0 || d < 0)
            return 0;
        else if(d == 0 && k == 0)
            return 1;
        int res = 0;
        for(int i = 0; i < k; i++)
            res += solution(d-1, i);
        return res;
    }
}
