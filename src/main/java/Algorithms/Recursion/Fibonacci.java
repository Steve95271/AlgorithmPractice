package Algorithms.Recursion;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(8));
    }

    private static int fibonacci(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        // 计算n-1项
        int n1 = fibonacci(n - 1);
        // 计算n-2项
        int n2 = fibonacci(n - 2);

        return n1 + n2;
    }

}
