package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(f(2000));
    }

    public static long f(int n){
        if (n == 0 ){
            return 0;
        } else if (n == 1) {
            return 1;
        }

        long x = f(n - 1);
        long y = f(n - 2);

        return x + y;
    }
}
