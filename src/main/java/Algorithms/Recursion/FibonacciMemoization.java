package Algorithms.Recursion;

import java.util.Arrays;

public class FibonacciMemoization {
    private int[] cache;

    public int calculateFib(int n) {
        cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return cal(n);
    }

    private int cal(int n) {

        if (cache[n] != -1) {
            return cache[n];
        }

        int n1 = cal(n - 1);
        int n2 = cal(n - 2);

        return cache[n] = n1 + n2;
    }
}
