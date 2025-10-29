package Algorithms.Recursion;

public class Fibonacci {

    public static int calculate(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        int n1 = calculate(n - 1);
        int n2 = calculate(n - 2);

        return n1 + n2;
    }

}
