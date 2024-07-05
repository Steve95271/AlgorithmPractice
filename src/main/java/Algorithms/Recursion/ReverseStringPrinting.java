package Algorithms.Recursion;

public class ReverseStringPrinting {

    private static void recursion(int n, String str) {
        if (n == str.length()) {
            return;
        }
        recursion(n + 1, str);
        System.out.println(str.charAt(n));
    }

    public static void main(String[] args) {
        String str = "ABCD";
        recursion(0, str);
    }

}
