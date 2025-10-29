package Algorithms.Recursion;

public class ReverseStringPrinting {

    public static void print(String string) {

        print(string, 0);

    }

    private static void print(String string, int n) {

        if (n == string.length()) {
            return;
        }

        print(string, n + 1);

        // after
        System.out.print(string.charAt(n) + " ");

    }

}
