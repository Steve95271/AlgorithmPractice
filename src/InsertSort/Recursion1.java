package InsertSort;

public class Recursion1 {

    public static void main(String[] args) {
        int sum = getSum(5);

        System.out.println(sum);

        long factorial = factorial(35);

        System.out.println(factorial);
    }

    public static int getSum(int n){
        if(n == 1){
            return 1;
        }
        return n + getSum(n - 1);

    }

    public static long factorial(long num){
        if(num != 1){
            return num * factorial(num - 1);
        }

        return 1;
    }
}
