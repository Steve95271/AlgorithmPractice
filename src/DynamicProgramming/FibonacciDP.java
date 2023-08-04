package DynamicProgramming;

public class FibonacciDP {
    public static void main(String[] args) {
        long result = fibonacci(2000);

        System.out.println(result);
    }

    public static long fibonacci(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        if (n == 0) {
            return dp[0];
        }

        if (n == 1) {
            return dp[1];
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
