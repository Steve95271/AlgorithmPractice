package Algorithms.Recursion;

import java.util.Arrays;

public class FibonacciMemoization {
    public static void main(String[] args) {
        System.out.println(fibonacci(20000));
    }

    private static int fibonacci(int n) {
        if (n == 0) return 0;
        //使用数组储存已经计算过的第n项的结果以减少重复计算
        int[] buffer = new int[n + 1];
        //一开始先把数组的所有值设为负一去判断第n项是否已经计算过
        Arrays.fill(buffer, -1);
        //设好第0项和第1项的值
        buffer[0] = 0;
        buffer[1] = 1;

        //调用另一个递归方法进行计算
        return recursiveCalculateFib(n, buffer);
    }

    private static int recursiveCalculateFib(int n, int[] buffer) {
        //判断：如果buffer中的第n项不等于负一，说明该项的值已经计算过，直接返回。
        if (buffer[n] != -1) {
            return buffer[n];
        } else {
            return buffer[n] = recursiveCalculateFib(n - 1, buffer) + recursiveCalculateFib(n - 2, buffer);
        }
    }
}
