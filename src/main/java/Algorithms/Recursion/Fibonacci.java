package Algorithms.Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib2(2000000));
    }

    public static int fib(int n){
        if (n == 0 ){
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int x = fib(n - 1);
        int y = fib(n - 2);

        return x + y;
    }

    public static int fib2(int n) {
        if (n == 0 ){
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int cont = 2;
        int n0 = 0;
        int n1 = 1;
        int tempNTerm;
        while (cont <= n) {
            tempNTerm = n0 + n1;
            n0 = n1;
            n1 = tempNTerm;
            cont++;
        }
        return n1;
    }


}
